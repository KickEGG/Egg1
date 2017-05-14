package com.kickegg.framework.helper;

import com.kickegg.framework.annotation.Inject;
import com.kickegg.framework.util.ReflectionUtil;
import com.kickegg.util.CollectionUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入助手类
 * <p>
 * Created by 44935 on 2017-05-14.
 */
public final class IocHelper {
    static {
        //获取所有bean类与bean之间的映射关系（简称bean map）
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //遍历beanmap
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //从 beanMap 中获取bean 类与bean 实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //从 bean类定义的所有成员变量（简称 bean field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    //遍历bean field
                    for (Field beanField : beanFields) {
                        //判断当前成员变量bean field 是否带有Inject 注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            //在bean map中获取bean field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                //通过反射初始化成员变量BeanField 的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }

                        }
                    }
                }
            }
        }
    }
}
