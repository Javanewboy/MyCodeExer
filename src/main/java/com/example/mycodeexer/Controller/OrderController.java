package com.example.mycodeexer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {
    // 1.请求注解
    @RequestMapping("/selectOrder")
// 2.响应体注解，添加此注解后，可以通过返回值的方式响应给客户端数据
    @ResponseBody
    public String selectOrder(){
        return "查询订单成功~~";
    }

    // 处理删除订单请求
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public String deleteOrder(){
        return "删除订单成功";
    }
    // 处理查询订单请求
    @RequestMapping("createOrder")
    @ResponseBody
    public String selectOrderById(){
        return "创建订单成功";
    }
}
