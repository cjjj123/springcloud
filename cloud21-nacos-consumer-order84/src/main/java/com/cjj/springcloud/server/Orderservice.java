package com.cjj.springcloud.server;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.server.impl.OrderserviceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/13
 * Time:22:11
 */
@FeignClient(value = "nacos-payment-provider", fallback = OrderserviceImpl.class)
public interface Orderservice {

    @GetMapping("/paymentSQL/{id}")
    CommonResult paymentSQL(@PathVariable("id") Long id);
}
