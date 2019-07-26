package com.lwl.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * author liuweilong
 * date 2019/7/26 10:31
 * desc
 */
@Configuration
public class ESConfig {
    @Value("${elasticsearch.address}")
    private String address;

    @Bean
    @Profile("dev")
    public RestHighLevelClient client(){
        String[] addresses = this.address.split(",");
        HttpHost[] hosts = new HttpHost[addresses.length];
        for (int i = 0; i < hosts.length; i++) {
            String address = addresses[i];
            String[] split = address.split(":");
            hosts[i] = new HttpHost(split[0], Integer.valueOf(split[1]));
        }
        return new RestHighLevelClient(RestClient.builder(hosts));
    }
}
