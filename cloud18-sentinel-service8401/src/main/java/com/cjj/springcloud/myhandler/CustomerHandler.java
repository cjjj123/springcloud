package com.cjj.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cjj.springcloud.beans.CommonResult;

/**
 * xiangjiaoyun
 * author:chenjianjie
 * Date:2020/7/13
 * Time:14:35
 */
public class CustomerHandler {

    public static CommonResult handler(BlockException blockexception){
        return new CommonResult(444, "按自定义限流测试失败");
    }

}
