package com.kickegg.framework;

import com.kickegg.framework.helper.BeanHelper;
import com.kickegg.framework.helper.ClassHelper;
import com.kickegg.framework.helper.ControllerHelper;
import com.kickegg.framework.helper.IocHelper;
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
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
