package com.kickegg.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义事务控制注解
 * 该注解只能用于方法级别
 * 凡是对数据库有变更的方法，都应该使用此注解，以保证一旦方法操作失败，整个方法都可以回滚
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transation {
}
