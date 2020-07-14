package com.cjj.springcloud.server.impl;

import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.server.Orderservice;
import org.springframework.stereotype.Service;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/13
 * Time:22:13
 */
@Service
public class OrderserviceImpl implements Orderservice {
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(444,"paymentSQL***回调失败");
    }
}
