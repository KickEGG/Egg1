package com.kickegg.framework.helper;

import com.kickegg.framework.annotation.Action;
import com.kickegg.framework.bean.Handler;
import com.kickegg.framework.bean.Request;
import com.kickegg.framework.util.ArrayUtil;
import com.kickegg.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * <p>
 * Created by 44935 on 2017-05-14.
 */
public final class ControllerHelper {
    /**
     * 用于存放请求与处理器的映射关系
     */
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        // 获取所有的Controller类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            // 遍历这些Controller类中定义的方法
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    // 遍历这些controller类中的方法
                    for (Method method : methods) {
                        // 判断当前方法是否带有action注解
                        if (method.isAnnotationPresent(Action.class)) {
                            // 从action注解中获取URL映射
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            // 验证URL映射规则
                            if(mapping.matches(("\\w+:/\\w*"))){
                                String[] array = mapping.split(":");
                                if(ArrayUtil.isNotEmpty(array)&&array.length==2){
                                    // 获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler hander = new Handler(controllerClass,method);
                                    // 初始化 Action Map
                                    ACTION_MAP.put(request,hander);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
