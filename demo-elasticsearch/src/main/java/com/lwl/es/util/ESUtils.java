package com.lwl.es.util;

import com.alibaba.fastjson.JSONObject;
import com.lwl.es.entity.search.ESField;
import com.lwl.es.entity.search.ESIndex;
import com.lwl.es.entity.search.TypeWrapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/**
 * author liuweilong
 * date 2019/7/26 18:09
 * desc
 */
@Slf4j
public class ESUtils {
    public static final String CUSTOM_OBJECT = "customObject";
    public static final String PROPERTIES = "properties";
    public static final String TYPE = "type";
    public static final String FORMAT = "format";
    public static final String TERM_VECTOR = "term_vector";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";
    public static final int MAX_STRING_LENGTH = 100;

    public static void analyzeMapping(Class clazz, XContentBuilder builder, String indexName) throws IOException {
        builder.startObject();
        analyzeClass(clazz, builder, indexName, true);
        builder.endObject();
    }

    public static String analyzeIndexName(Class clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        String indexName = null;
        for (Annotation annotation : annotations) {
            if (annotation instanceof ESIndex) {
                ESIndex indexAnno = (ESIndex) annotation;
                indexName = indexAnno.value();
            }
        }
        checkIndexNameLowerCase(indexName);
        if (Objects.isNull(indexName)) {
            String simpleName = clazz.getSimpleName();
            indexName = toCamel(simpleName);
        }

        return indexName;
    }

    public static <T> List<T> convertHitList(SearchHit[] searchHits, Class<T> clazz) {
        if (searchHits.length == 0) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>(searchHits.length);
        for (SearchHit searchHit : searchHits) {
            String sourceString = searchHit.getSourceAsString();
            T obj = JSONObject.parseObject(sourceString, clazz);
            //将高亮字段替换原字段
            Map<String, HighlightField> highlightFieldMap = searchHit.getHighlightFields();
            list.add(obj);
            if (highlightFieldMap.isEmpty()) {
                continue;
            }
            for (Map.Entry<String, HighlightField> entry : highlightFieldMap.entrySet()) {
                String key = entry.getKey();
                HighlightField value = entry.getValue();
                Text[] fragments = value.getFragments();
                try {
                    Field highlightField = clazz.getDeclaredField(key);
                    highlightField.setAccessible(true);
                    String highlightString = fragments[0].string();
                    highlightField.set(obj, highlightString);
                } catch (NoSuchFieldException e) {
                    log.error("转换es hit，字段反射时没有找到对应名称的字段", e);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return list;
    }

    public static <T> T convertHitEntity(SearchHit dataHit, Class<T> clazz) {
        return JSONObject.parseObject(dataHit.getSourceAsString(), clazz);
    }

    private static void analyzeClass(Class clazz, XContentBuilder builder, String objectName, boolean isRoot) throws IOException {
        Field[] declaredFields = clazz.getDeclaredFields();
        if (!isRoot) {
            builder.startObject(objectName);
        }
        {
            builder.startObject(PROPERTIES);
            for (Field declaredField : declaredFields) {
                {
                    //只解析private类型
                    if (!Modifier.isPrivate(declaredField.getModifiers())) {
                        continue;
                    }
                    TypeWrapper typeWrapper = analyzeType(declaredField);
                    String type = typeWrapper.getType();
                    if (CUSTOM_OBJECT.equals(type)) {
                        analyzeClass(typeWrapper.getClazz(), builder, declaredField.getName(), false);
                    } else {
                        analyzeCommonProperties(builder, declaredField);
                    }
                }
            }
            builder.endObject();
        }
        if (!isRoot) {
            builder.endObject();
        }
    }

    private static void analyzeCommonProperties(XContentBuilder builder, Field declaredField) throws IOException {
        String name = declaredField.getName();
        builder.startObject(name);
        {
            ESField esField = declaredField.getAnnotation(ESField.class);
            if (esField != null) {
                buildByESField(builder, esField, declaredField);
            } else {
                buildDefault(builder, declaredField);
            }
        }
        builder.endObject();
    }

    private static void buildDefault(XContentBuilder builder, Field declaredField) throws IOException {
        TypeWrapper defaultType = getDefaultTypeWrapper(declaredField, declaredField.getType());
        builder.field(TYPE, defaultType.getType());
        if (declaredField.getType() == Date.class) {
            String format = analyzeFormat(declaredField);
            builder.field(FORMAT, format);
        }
    }

    private static void buildByESField(XContentBuilder builder, ESField esField, Field declaredField) throws IOException {
        String format = esField.format();
        if (!StringUtils.isEmpty(format)) {
            builder.field(FORMAT, format);
        }
        String termVector = esField.termVector();
        if (!StringUtils.isEmpty(termVector)) {
            builder.field(TERM_VECTOR, termVector);
        }
        String type = esField.type();
        if (!StringUtils.isEmpty(type)) {
            builder.field(TYPE, type);
        } else {
            builder.field(TYPE, getDefaultTypeWrapper(declaredField, declaredField.getType()).getType());
        }
    }

    private static String analyzeFormat(Field declaredField) {
        ESField typeAnno = declaredField.getAnnotation(ESField.class);
        if (Objects.nonNull(typeAnno)) {
            return typeAnno.format();
        }
        return DEFAULT_DATE_FORMAT;
    }

    private static TypeWrapper analyzeType(Field declaredField) {
        ESField typeAnno = declaredField.getAnnotation(ESField.class);
        if (Objects.isNull(typeAnno) || StringUtils.isEmpty(typeAnno.type())) {
            //没有指定类型，就根据field获取默认类型
            return getDefaultTypeWrapper(declaredField, declaredField.getType());
        }
        TypeWrapper typeWrapper = new TypeWrapper();
        typeWrapper.setClazz(declaredField.getType());
        typeWrapper.setType(typeAnno.type());
        return typeWrapper;
    }

    private static TypeWrapper getDefaultTypeWrapper(Field field, Class clazz) {
        TypeWrapper typeWrapper = new TypeWrapper();
        if (clazz == Byte.class) {
            typeWrapper.setType("byte");
            typeWrapper.setClazz(Byte.class);
            return typeWrapper;
        }
        if (clazz == Short.class) {
            typeWrapper.setType("short");
            typeWrapper.setClazz(Short.class);
            return typeWrapper;
        }
        if (clazz == Integer.class) {
            typeWrapper.setType("integer");
            typeWrapper.setClazz(Integer.class);
            return typeWrapper;
        }
        if (clazz == Long.class) {
            typeWrapper.setType("long");
            typeWrapper.setClazz(Long.class);
            return typeWrapper;
        }
        if (clazz == Double.class) {
            typeWrapper.setType("double");
            typeWrapper.setClazz(Double.class);
            return typeWrapper;
        }
        if (clazz == Float.class) {
            typeWrapper.setType("float");
            typeWrapper.setClazz(Float.class);
            return typeWrapper;
        }
        if (clazz == Date.class) {
            typeWrapper.setType("date");
            typeWrapper.setClazz(Date.class);
            return typeWrapper;
        }
        if (clazz == Boolean.class) {
            typeWrapper.setType("boolean");
            typeWrapper.setClazz(Boolean.class);
            return typeWrapper;
        }
        if (clazz == String.class) {
            typeWrapper.setType("text");
            typeWrapper.setClazz(String.class);
            return typeWrapper;
        }
        if (clazz == List.class) {
            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
            Type[] types = parameterizedType.getActualTypeArguments();
            Class type = (Class) types[0];
            return getDefaultTypeWrapper(field, type);
        }
        typeWrapper.setType(CUSTOM_OBJECT);
        typeWrapper.setClazz(clazz);
        return typeWrapper;
    }


    private static String toCamel(String simpleName) {
        char[] chars = simpleName.toCharArray();
        List<Character> list = new ArrayList<>();

        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                char lowerCase = Character.toLowerCase(aChar);
                list.add('_');
                list.add(lowerCase);
                continue;
            }
            list.add(aChar);
        }
        char[] camelChars = new char[list.size()];
        //从第二个开始
        for (int i = 1; i < list.size(); i++) {
            camelChars[i] = list.get(i);
        }
        return new String(camelChars);
    }

    private static void checkIndexNameLowerCase(String indexName) {
        if (StringUtils.isEmpty(indexName)) {
            return;
        }
        char[] chars = indexName.toCharArray();
        for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) {
                throw new IllegalStateException("index name must be lower case");
            }
        }
    }


}
