package com.cjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/1
 * Time:14:16
 */
@SpringBootApplication
@EnableFeignClients
public class OrderMainFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign80.class, args);
    }
}
