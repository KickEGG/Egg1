package com.kickegg.framework.helper;

import com.kickegg.util.PropsUtil;

import java.util.Properties;


/**
 * Created by 44935 on 2017-04-20.
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPERTIES = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获得jdbc驱动
     *
     * @return
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获得url
     *
     * @return
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_URL);
    }

    /**
     * 获得用户名
     *
     * @return
     */
    public static String getJdbcUsername() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取密码
     *
     * @return
     */
    public static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 基础包名
     *
     * @return
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * jsp文件的路径
     *
     * @return
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    /**
     * 静态资源文件路径
     *
     * @return
     */
    public static String getAppAssertPath() {
        return PropsUtil.getString(CONFIG_PROPERTIES, ConfigConstant.APP_ASSERT_PATH, "/assert/");
    }
}
