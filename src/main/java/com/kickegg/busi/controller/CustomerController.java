//package com.kickegg.busi.controller;
//
//import com.kickegg.busi.model.Customer;
//import com.kickegg.busi.service.CustomerService;
//
//import javax.xml.ws.Action;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by 44935 on 2017-04-18.
// */
//@Controller
//public class CustomerController {
//    @Inject
//    private CustomerService customerService;
//    /**
//     * 进入客户列表界面
//     */
//    @Action("get:/customer")
//    public view index(Param param){
//        List<Customer> customerList=customerService.getCustomerList();
//        return new view("customer_show.jsp").addModel("customerList",customerList);
//    }
//    /**
//     * 显示客户信息
//     */
//    @Action("get:/customer_show")
//    public view show(Param param){
//        long id=param.getLong("id");
//        Customer customer=customerService.getCustomer(id);
//        return new view("customer_show.jsp").addModel("customer",customer);
//    }
//    /**
//     * 进入创建客户 界面
//     */
//    @Action("get:/customer_create")
//    public view create(Param param){
//        return new view("customer_create.jsp");
//    }
//    /**
//     * 处理创建客户请求
//     */
//    @Action("post:/customer_create")
//    public Data createSubmit(Param param){
//        Map<String,Object> fieldMap=param.getMap();
//        boolean result=customerService.createCustomer(fieldMap);
//        return new Data(result);
//    }
//    /**
//     * 进入编辑客户界面
//     */
//    @Action("get:/customer_edit")
//    public view edit(Param param){
//        long id=param.getLong("id");
//        Customer customer=customerService.getCustomer(id);
//        return new View("customer_edit.jsp").addModel("customer",customer);
//    }
//    /**
//     * 处理编辑客户请求
//     */
//    @Action("put:/customer_edit")
//    public Data editSubmit(Param param){
//        long id=param.getLong("id");
//        Map<String,Object> fieldMap=param.getMap();
//        boolean result=customerService.updateCustomer(id,fieldMap);
//        return new Data(result);
//    }
//    /**
//     * 处理编辑客户请求
//     */
//    @Action("delete:/customer_edit")
//    public view delete(Param param){
//        long id=param.getLong("id");
//        boolean result=customerService.deleteCustomer(id);
//        return new Data(result);
//    }
//}
