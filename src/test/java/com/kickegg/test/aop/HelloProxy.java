package com.kickegg.test.aop;

/**
 * Created by 44935 on 2017-05-14.
 */
public class HelloProxy implements Hello {
    private Hello hello;

    public HelloProxy(){
        hello = new HelloImpl();
    }

    @Override
    public void say(String name) {
        before();
        hello.say(name);
        after();
    }

    private void before(){
        System.out.println("Before");
    }

    private void after(){
        System.out.println("After");
    }

    public static void main(String[] args){
        Hello helloProxy = new HelloProxy();
        helloProxy.say("jack");
    }
}
