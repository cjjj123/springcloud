package com.cjj.springcloud.controller;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.beans.Payment;
import com.cjj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/6/28
 * Time:13:45
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("***********插入结果:{}",result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort"+port, result);
        }else{
            return new CommonResult(444,"插入数据库失败");
        }
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("***********获取结果:{}",payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort"+port,payment);
        }else{
            return new CommonResult(444,"查询失败");
        }
    }

    @GetMapping(value = "/payment/lb")
    public String lb(){
        return port;
    }

}
