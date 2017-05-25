package com.kickegg.json;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] argv) throws Exception {
        List a = new ArrayList() ;
        a.add(new A("1", 1)) ;
        a.add(new A("2", 2)) ;
        a.add(new A("3", 3)) ;
        String test = "{\"name\":\"" + "kevin" + " \",\"age\":\"" + "222" + "\"}";
        a.add(test) ;

        List b = new ArrayList() ;
        b.add("a") ;
        b.add("a") ;
        b.add(a) ;


        //直接返回对象就不会有反斜杠。。
        System.out.println(b.toString()) ;
        Object o = JSONObject.toJSON(a) ;
        Object z = JSONObject.toJSON(b) ;
        System.out.println(JSONObject.toJSON(o)) ;
        System.out.println(JSONObject.toJSONString(o,false));

        System.out.println(JSONObject.toJSON(z)) ;
        System.out.println(JSONObject.toJSONString(b,false));

//        System.out.println(JSONObject.toJSON(o)) ;
//        System.out.println(JSONObject.toJSON(o)) ;
    }
}



class A{
    String name ;
    Integer age ;
    A(String name , Integer age){
        this.name = name ;
        this.age = age ;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

}