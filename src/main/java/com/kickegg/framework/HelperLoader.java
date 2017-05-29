package com.kickegg.framework;

import com.kickegg.framework.helper.*;
import com.kickegg.framework.util.ClassUtil;

/**
 * 加载相应的helper类
 * 设计理由：也可以分别调用*.class，这个类的处理目的只是让加载更集中
 *
 * Created by 44935 on 2017-05-14.
 */
public final class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                // 注意加载顺序
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,//aop在前，先要通过aop获取代理对象，再交给ioc进行依赖注入
                IocHelper.class,
                ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
