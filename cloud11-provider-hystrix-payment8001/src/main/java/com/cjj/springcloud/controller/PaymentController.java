package com.cjj.springcloud.controller;

import com.cjj.springcloud.servcie.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/2
 * Time:11:10
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("server.port")
    private String port;

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/paymentInfo_TimeOut/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/paymentInfo_Breaker/{id}")
    public String paymentInfo_Breaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Breaker(id);
        log.info("result:" + result);
        return result;
    }

}
