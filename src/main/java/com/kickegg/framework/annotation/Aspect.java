package com.kickegg.framework.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 *
 * Created by 44935 on 2017-05-21.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     *  注解
     */
    // ?
    Class<? extends Annotation> value();
}
