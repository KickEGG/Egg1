package com.kickegg.framework.helper;

import com.kickegg.framework.util.ClassUtil;

import java.util.Set;

/**
 * 类操作助手类
 *
 * Created by 44935 on 2017-05-11.
 */
public class ClassHelper {

    /*
     * 定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }
    
    /*
     * 获取应用包下名下的所有类
     */

    // TODO: 2017-05-11  
}
