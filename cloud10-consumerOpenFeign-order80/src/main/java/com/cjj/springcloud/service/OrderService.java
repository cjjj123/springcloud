package com.cjj.springcloud.service;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.beans.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/1
 * Time:14:18
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Service
public interface OrderService {

    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}
