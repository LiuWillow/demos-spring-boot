package com.lwl.rest.wx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/21 17:21
 */
@Configuration
public class RestConfig {
    @Bean
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);

        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate(messageConverters);
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }


}
