package com.kickegg.framework.proxy;

import com.kickegg.framework.proxy.impl.ProxyChain;

/**
 * 代理接口
 *
 * Created by 44935 on 2017-05-21.
 */
public interface Proxy {

    /**
     * 实现类中将提供横切逻辑
     *
     * 执行链式代理
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
