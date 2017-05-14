package com.kickegg.framework.bean;

/**
 * 请求转发器-返回数据对象
 *
 * Created by 44935 on 2017-05-14.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model){
        this.model=model;
    }

    public Object getModel() {
        return model;
    }
}
