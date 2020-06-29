package com.cjj.springcloud.dao;

import com.cjj.springcloud.beans.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/6/28
 * Time:10:50
 */
@Mapper
public interface PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
