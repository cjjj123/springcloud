package com.cjj.springcloud.service.impl;

import com.cjj.springcloud.service.PaymentHystrixServer;
import org.springframework.stereotype.Component;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/7
 * Time:10:32
 */
@Component
public class PaymentHystrixServerImpl implements PaymentHystrixServer {


    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK失败，请稍后再试";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut失败，请稍后再试";
    }
}
