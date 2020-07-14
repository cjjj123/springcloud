package com.cjj.springcloud.controller;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.service.PaymentHystrixServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/6
 * Time:11:11
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutFailBackAll")
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixServer paymentHystrixServer;

    @GetMapping("/consumer/payment/hystrix/paymentInfo_OK/{id}")
    public CommonResult paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixServer.paymentInfo_OK(id);
        return new CommonResult(200,"success",result);
    }


    @GetMapping("/consumer/payment/hystrix/paymentInfo_TimeOut/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFailBack", commandProperties = {
            @HystrixProperty(name= "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    //@HystrixCommand
    public CommonResult paymentInfo_TimeOut(@PathVariable("id") Integer id){
        //int i = 10/0;
        String result = paymentHystrixServer.paymentInfo_TimeOut(id);
        return new CommonResult(200, "success", result);

    }

    public CommonResult paymentInfo_TimeOutFailBack(Integer id){
        return new CommonResult(500, "请求失败，请稍后再尝试");
    }

    public CommonResult paymentInfo_TimeOutFailBackAll(){
        return new CommonResult(500, "全局请求失败，请稍后再尝试");
    }
}
