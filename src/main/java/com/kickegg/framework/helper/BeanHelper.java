package com.kickegg.framework.helper;

import com.kickegg.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类，存取bean对象by Map
 *
 * final class which can't be extended and override by child , except extended by child
 * Created by 44935 on 2017-05-14.
 */
public final class BeanHelper {
    /**
     * 定义bean映射（用于存放bean类与bean实例的映射关系）
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取bean映射
     */
    public static Map<Class<?>,Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取bean实例
     */
    public static <T> T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class");
        }
        return (T) BEAN_MAP.get(cls);
    }

    /**
     * 设置bean实例,将bean实例放入Bean map中
     */
    public static void setBean(Class<?> cls,Object obj){
        BEAN_MAP.put(cls, obj);
    }
}
