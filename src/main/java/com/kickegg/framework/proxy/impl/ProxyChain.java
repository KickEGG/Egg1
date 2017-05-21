package com.kickegg.framework.proxy.impl;

import com.kickegg.framework.proxy.Proxy;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 代理练
 *
 * Created by 44935 on 2017-05-21.
 */
public class ProxyChain {

    private final Class<?> targetClass;
    private final Object targetObject;
    private final Method targerMethod;
    private final MethodProxy methodProxy;
    private final Object[] methodParams;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxyIndex = 0;

    public Object doProxyChain() throws Throwable{
        Object methodResult;
        if(proxyIndex < proxyList.size()){
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        }else{
            methodResult = methodProxy.invokeSuper(targetObject,methodParams);
        }
        return  methodResult;
    }

    public ProxyChain(Class<?> targetClass, Object targetObject, Method targerMethod, MethodProxy methodProxy, Object[] methodParams) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.targerMethod = targerMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
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
