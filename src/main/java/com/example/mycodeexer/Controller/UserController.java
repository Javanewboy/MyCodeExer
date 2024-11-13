package com.example.mycodeexer.Controller;

import com.example.mycodeexer.entiy.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/v1/users")
@Api(value = "用户管理系统")
public class UserController {
    @ResponseBody
    @RequestMapping("login1")
    @ApiOperation(value = "输入用户名和密码", response = User.class)
    public String login(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        return username + ":" + password;
        return "登录页面";
    }
    @RequestMapping("login")
    @ResponseBody
    public String login(User user){
        log.info("成功输出"+user.getUsername());
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        return username + ":" + password;
        return user.toString();
    }
    @ResponseBody
    @RequestMapping("register")
    @ApiOperation(value = "输入用户名和密码()", response = User.class)
    public String register(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        return username + ":" + password;
        return "注册页面";
    }

}
