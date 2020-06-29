package com.cjj.springcloud.service;

import com.cjj.springcloud.beans.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/6/28
 * Time:11:17
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
