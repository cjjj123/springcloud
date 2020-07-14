package com.cjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/6
 * Time:11:04
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderMainHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainHystrix80.class, args);
    }
}
