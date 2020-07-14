package com.cjj.springcloud.servcie.impl;

import cn.hutool.core.util.IdUtil;
import com.cjj.springcloud.servcie.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/2
 * Time:10:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return Thread.currentThread().getName()+ "paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O";
    }


    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutFallback", commandProperties = {
            @HystrixProperty(name= "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName()+ "paymentInfo_TimeOut" + id + "\t" + "O(∩_∩)O" + "耗时：" + timeNumber;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_BreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentInfo_Breaker(Integer id) {
        if(id < 0){
            throw  new RuntimeException("***********id 不能为负数");
        }
        String number = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + number;
    }

    public String paymentInfo_TimeOutFallback(Integer id) {
        return Thread.currentThread().getName()+ "系统繁忙，请稍后再试" + id + "\t" + "/(ㄒoㄒ)/~~" ;
    }

    public String paymentInfo_BreakerFallback(Integer id) {
        return Thread.currentThread().getName()+ "系统繁忙，请稍后再试" + id + "\t" + "/(ㄒoㄒ)/~~" ;
    }



}
