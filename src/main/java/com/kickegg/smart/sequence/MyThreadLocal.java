package com.kickegg.smart.sequence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal实质是封装了一个map
 *
 * @param <T>
 */
public class MyThreadLocal<T> {
    private Map<Thread,T> container =Collections.synchronizedMap(new HashMap<Thread,T>());

    public void set(T value){
        container.put(Thread.currentThread(),value);
    }

    public void remove(){
        container.remove(Thread.currentThread());
    }

    public T get(){
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if(value==null&&!container.containsKey(thread)){
            value=initialValue();
            container.put(thread,value);
        }
        return value;
    }


    protected T initialValue(){
        return null;
    }
}
