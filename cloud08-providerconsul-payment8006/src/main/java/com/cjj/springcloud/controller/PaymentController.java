package com.cjj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/6/29
 * Time:23:04
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/consul")
    public String paymentcon(){
        return "springboot whit consul" + port + "\t" + UUID.randomUUID().toString();
    }

}
