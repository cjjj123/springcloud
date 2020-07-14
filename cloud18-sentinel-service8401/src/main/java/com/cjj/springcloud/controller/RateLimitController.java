package com.cjj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cjj.springcloud.beans.CommonResult;
import com.cjj.springcloud.beans.Payment;
import com.cjj.springcloud.myhandler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/13
 * Time:11:23
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200, "按URL限流测试OK", new Payment(2020L, "serial002"));
    }

    @GetMapping("/handler")
    @SentinelResource(value = "handler", blockHandlerClass = CustomerHandler.class,
    blockHandler = "handler")
    public CommonResult handler(){
        return new CommonResult(200, "按自定义限流测试OK", new Payment(2020L, "serial003"));
    }




}
