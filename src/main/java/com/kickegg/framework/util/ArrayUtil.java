package com.kickegg.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组助手类 用于加载IocHelp
 *
 * Created by 44935 on 2017-05-14.
 */
public final class ArrayUtil {
    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);

    }

}
