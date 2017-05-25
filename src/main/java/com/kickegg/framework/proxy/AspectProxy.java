package com.kickegg.framework.proxy;


import com.kickegg.framework.proxy.impl.ProxyChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


/**
 * 切面代理
 * 切面类，模板方法，在目标方法被调用的前后增加相应逻辑
 * <p>
 * Created by 44935 on 2017-05-21.
 */
public abstract class AspectProxy implements Proxy {
    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;

        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargerMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        // 这里实现调用框架，
        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params,result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            logger.error("proxy failure!", e);
            error(cls, method, params, e);
            throw e;
        } finally {
            end();
        }

        return result;
    }

    public void begin() {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        return true;
    }

    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {

    }

    public void after(Class<?> cls, Method method, Object[] params,Object result) throws Throwable {

    }

    public void error(Class<?> cls, Method method, Object[] params,Throwable e) throws Throwable {

    }

    public void end() {

    }
}
