package com.lwl.es.util;

import com.lwl.es.entity.ESType;
import com.lwl.es.entity.IndexName;
import com.lwl.es.entity.TypeWrapper;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * author liuweilong
 * date 2019/7/26 18:09
 * desc
 */
public class ESUtils {
    public static final String CUSTOM_OBJECT = "customObject";
    public static final String PROPERTIES = "properties";
    public static final String TYPE = "type";
    public static final String FORMAT = "format";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";

    public static void analyzeMapping(Class clazz, XContentBuilder builder, String indexName) throws IOException {
        builder.startObject();
        analyzeClass(clazz, builder, indexName, true);
        builder.endObject();
    }

    public static String analyzeIndexName(Class clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        String indexName = null;
        for (Annotation annotation : annotations) {
            if (annotation instanceof IndexName) {
                IndexName indexNameAnnotation = (IndexName) annotation;
                indexName = indexNameAnnotation.value();
            }
        }
        checkIndexNameLowerCase(indexName);
        if (Objects.isNull(indexName)) {
            String simpleName = clazz.getSimpleName();
            indexName = toCamel(simpleName);
        }

        return indexName;
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
                    TypeWrapper typeWrapper = analyzeType(declaredField);
                    String type = typeWrapper.getType();
                    if (CUSTOM_OBJECT.equals(type)) {
                        analyzeClass(typeWrapper.getClazz(), builder, declaredField.getName(), false);
                        continue;
                    }
                    analyzeCommonProperties(builder, declaredField);
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
            TypeWrapper typeWrapper = analyzeType(declaredField);
            String type = typeWrapper.getType();
            builder.field(TYPE, type);
            if (declaredField.getType() == Date.class) {
                String format = analyzeFormat(declaredField);
                builder.field(FORMAT, format);
            }
        }
        builder.endObject();
    }

    private static String analyzeFormat(Field declaredField) {
        ESType typeAnno = declaredField.getAnnotation(ESType.class);
        if (Objects.nonNull(typeAnno)) {
            return typeAnno.format();
        }
        return DEFAULT_DATE_FORMAT;
    }

    private static TypeWrapper analyzeType(Field declaredField) {
        ESType typeAnno = declaredField.getAnnotation(ESType.class);
        if (Objects.isNull(typeAnno) || StringUtils.isEmpty(typeAnno.value())) {
            //没有指定类型，就根据field获取默认类型
            return getDefaultType(declaredField, declaredField.getType());
        }
        TypeWrapper typeWrapper = new TypeWrapper();
        typeWrapper.setClazz(declaredField.getType());
        typeWrapper.setType(typeAnno.value());
        return typeWrapper;
    }

    private static TypeWrapper getDefaultType(Field field, Class clazz) {
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
            return getDefaultType(field, type);
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
                throw new IllegalStateException("index name should be lower case");
            }
        }
    }


}
