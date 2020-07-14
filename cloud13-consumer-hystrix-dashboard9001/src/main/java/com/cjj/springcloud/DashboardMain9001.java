package com.cjj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/7
 * Time:20:47
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class, args);
    }
}
