package com.kickegg.framework.bean;

/**
 * 封装请求信息
 *
 * Created by 44935 on 2017-05-14.
 */
public class Request {
    /**
     * 请求方法
     */
    private String requestMethod;
    /**
     * 请求路径
     */
    private String requestPath;

    public Request(String requestMethod,String requestPath ) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;

    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
