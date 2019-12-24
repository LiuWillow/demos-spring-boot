package com.lwl.plus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.lwl.plus.plugin.MyPageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author liuweilong
 * date 2019/12/24 2:53 下午
 * desc
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * mybatis-plus提供的分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 自定义的分页插件
     * @return
     */
//    @Bean
//    public Interceptor paginationInterceptor(){
//        return new MyPageInterceptor();
//    }
}
