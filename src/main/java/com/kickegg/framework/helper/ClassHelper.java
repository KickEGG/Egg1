package com.kickegg.framework.helper;

import com.kickegg.framework.annotation.Controller;
import com.kickegg.framework.annotation.Service;
import com.kickegg.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 * 获取应用包名下所有bean类的方法
 * <p>
 * Created by 44935 on 2017-05-11.
 */
public final class ClassHelper {

    /*
     * 定义类集合(用于存放所有需加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }
    
    /*
     * 获取应用包下名下的所有类
     */

    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classesSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classesSet.add(cls);
            }
        }
        return classesSet;
    }

    /**
     * 获取应用包名下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classesSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Controller.class)) {
                classesSet.add(cls);
            }
        }
        return classesSet;
    }

    /**
     * 获取应用包名下所有Bean类(包含：Service Controller)
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanClassesSet = new HashSet<Class<?>>();
        beanClassesSet.addAll(getServiceClassSet());
        beanClassesSet.addAll(getControllerClassSet());
        return beanClassesSet;
    }

    /**
     * 获取应用包名下某父类（或接口）的所有子类（或实现类）
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for(Class<?> cls:CLASS_SET){
            //TODO superClass.isAssignableFrom()?
            if(superClass.isAssignableFrom(cls)&&!superClass.equals(cls)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
