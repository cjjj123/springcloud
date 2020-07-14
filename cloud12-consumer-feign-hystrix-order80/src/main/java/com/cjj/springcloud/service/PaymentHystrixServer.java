package com.cjj.springcloud.service;

import com.cjj.springcloud.service.impl.PaymentHystrixServerImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/6
 * Time:11:12
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixServerImpl.class)
@Service
public interface PaymentHystrixServer {

    @GetMapping(value = "/payment/hystrix/paymentInfo_OK/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/paymentInfo_TimeOut/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
