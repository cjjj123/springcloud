package com.cjj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.beans.Payment;
import com.cjj.springcloud.server.Orderservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/13
 * Time:16:59
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private Orderservice orderservice;

    @Value("${service-url.nacos-user-service}")
    private String URL;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallBack")
    @SentinelResource(value = "fallBack", fallback = "handlerFallBack")
    public CommonResult fallBack(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(URL + "//paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("非法参数异常");
        }else if(result.getData() == null){
            throw new NullPointerException("非法参数异常");
        }
        return result;
    }


    public CommonResult handlerFallBack(@PathVariable("id") Long id){
        return new CommonResult(444, "兜底异常");
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id){
        return orderservice.paymentSQL(id);

    }


}
