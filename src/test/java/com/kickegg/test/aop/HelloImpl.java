package com.kickegg.test.aop;

/**
 * Created by 44935 on 2017-05-14.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello!" + name);
    }
}
