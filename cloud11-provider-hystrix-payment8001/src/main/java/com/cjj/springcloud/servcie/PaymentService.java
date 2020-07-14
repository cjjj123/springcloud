package com.cjj.springcloud.servcie;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/2
 * Time:10:46
 */
public interface PaymentService {

    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentInfo_Breaker(Integer id);
}
