package com.kickegg.framework.proxy.impl;

import com.kickegg.framework.proxy.Proxy;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理链
 * <p>
 * Created by 44935 on 2017-05-21.
 */
public class ProxyChain {

    private final Class<?> targetClass;// 目标类
    private final Object targetObject;// 目标对象
    private final Method targerMethod;// 目标方法
    private final MethodProxy methodProxy;// 方法代理类@cglib
    private final Object[] methodParams;// 方法参数

    private List<Proxy> proxyList = new ArrayList<Proxy>();// 代理列表
    private int proxyIndex = 0; // 代理索引,计数器

    public ProxyChain(Class<?> targetClass, Object targetObject,
                      Method targerMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targerMethod = targerMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    /**
     * @return
     * @throws Throwable
     */
    public Object doProxyChain() throws Throwable {
        Object methodResult;
        if (proxyIndex < proxyList.size()) {
            // 如果未达到list.size(),从list中取出对象调用Proxy接口的doProxy方法
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        } else {
            // 反之执行目标对象的业务逻辑
            methodResult = methodProxy.invokeSuper(targetObject, methodParams);
        }
        return methodResult;
    }


    public Class<?> getTargetClass() {
        return targetClass;
    }

    public Object getTargetObject() {
        return targetObject;
    }

    public Method getTargerMethod() {
        return targerMethod;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }
}
