package com.cjj.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/1
 * Time:16:03
 */
@Configuration
public class LogConfig {

    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
