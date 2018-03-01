package com.itfan.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ItfanZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItfanZuulApplication.class, args);
    }
}
