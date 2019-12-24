//package com.lwl.plus.plugin;
//
//import com.lwl.plus.to.BasePageTO;
//import org.apache.ibatis.executor.parameter.ParameterHandler;
//import org.apache.ibatis.executor.statement.StatementHandler;
//import org.apache.ibatis.plugin.*;
//import org.apache.ibatis.reflection.MetaObject;
//import org.apache.ibatis.reflection.SystemMetaObject;
//import org.apache.ibatis.session.RowBounds;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Properties;
//import java.util.regex.Pattern;
//
///**
// * type: 拦截的对象类型
// * method: 要拦截的方法
// * args：需要获取该方法的哪些参数
// */
//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
//public class MyPageInterceptor implements Interceptor {
//    /**
//     * 自己定义的分页规则，当mapper的方法以该字符开头，则表示需要分页
//     */
//    private String pagePrefix = "^page.*";
//
//    /**
//     * 拦截的逻辑
//     *
//     * @param invocation 拦截的对象
//     */
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        // 将拦截的对象转换为statementHandler
//        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
//
//        //由于方法名没有提供public方法，因此用mybatis提供的反射工具，获取mapper方法名
//        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
//        String statementId = (String) metaObject.getValue("delegate.mappedStatement.id");
//        String methodName = statementId.substring(statementId.lastIndexOf(".") + 1);
//
//        ParameterHandler parameterHandler = statementHandler.getParameterHandler();
//        Object parameterObject = parameterHandler.getParameterObject();
//        //如果方法名不包含了pagePrefix，或者参数中没有MyPage，则不管
//        if (!methodName.matches(pagePrefix) || !(parameterObject instanceof BasePageTO)) {
//            return invocation.proceed();
//        }
//        //执行自定义的分页逻辑
//        String originSql = statementHandler.getBoundSql().getSql();
//        BasePageTO basePageTO = (BasePageTO) parameterObject;
//
//        int pageSize = basePageTO.getPageSize();
//        int begin = (basePageTO.getPage() - 1) * pageSize;
//        String pageSql = originSql + " limit " + begin + "," + pageSize;
//
//        Connection connection = (Connection) invocation.getArgs()[0];
//        //包装count语句，暂时不考虑性能
//        String countSql = "select count(*) from (" + originSql + ") a";
//        PreparedStatement preparedStatement = connection.prepareStatement(countSql);
//        //TODO ????
//        parameterHandler.setParameters(preparedStatement);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        int count = resultSet.getInt(1);
//        resultSet.close();
//        preparedStatement.close();
//
//
//
//        metaObject.setValue("delegate.boundSql.sql", pageSql);
//        /*
//         * <p> 禁用内存分页 </p>
//         * <p> 内存分页会查询所有结果出来处理（这个很吓人的），如果结果变化频繁这个数据还会不准。</p>
//         */
//        metaObject.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
//        metaObject.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
//        return invocation.proceed();
//    }
//
//
//    /**
//     * 返回一个动态代理的对象
//     *
//     * @param target
//     * @return
//     */
//    @Override
//    public Object plugin(Object target) {
//        //mybatis提供的类，可以将对象用拦截器将目标包装为代理对象，里面调用了jdk动态代理的方法
//        return Plugin.wrap(target, this);
//    }
//
//    @Override
//    public void setProperties(Properties properties) {
//
//    }
//}
