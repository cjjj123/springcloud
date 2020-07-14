package com.cjj.springcloud.controller;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.beans.Payment;
import com.cjj.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/1
 * Time:14:18
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/payment/getPayment/{id}")
    public CommonResult getPaymeny(@PathVariable("id") Long id){
        CommonResult<Payment> payment = orderService.getPayment(id);
        return payment;

    }

}
