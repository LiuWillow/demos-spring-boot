package com.lwl.shardingsphere.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * author liuweilong
 * date 2019/11/12 16:55
 * desc
 */
@Configuration
@MapperScan("com.lwl.shardingsphere.mapper")
public class MybatisConfig {
    private final DataSource dataSource;

    //存在多数据源，指定一个sharding sphere的数据源
    public MybatisConfig(@Qualifier("dataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}