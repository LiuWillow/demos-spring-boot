package com.lwl.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author liuweilong
 * @description
 * @date 2019/5/5 17:29
 */
@RestController
public class WebFluxController {
    @GetMapping("/hello")
    public Mono<String> hello(){
        return Mono.just("hello");
    }
}
