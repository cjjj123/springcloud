package com.cjj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/9
 * Time:10:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/getInfo/{id}")
    private String getInfo(@PathVariable("id") Integer id){
        return "getInfo-port:" + port + "-----id:" + id;
    }

}
