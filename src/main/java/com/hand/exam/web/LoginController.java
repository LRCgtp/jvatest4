package com.hand.exam.web;

import com.hand.exam.entity.Customer;
import com.hand.exam.service.ILoginService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import com.hand.exam.utiils.UserToken;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @PostMapping("select")
    public ResultBean<Customer> select(@Param("name") String name, @Param("password") String password,
                                       HttpServletRequest request, HttpServletResponse response){
        Log.logger.info("LoginController开始插入参数");
        String uuid=null;
        ResultBean<Customer> result = iLoginService.login(name, password);
        if (result !=null){
            if (result.getCode() ==1){//登录成功
                Log.logger.info("LoginController登录成功了");
                uuid= UUID.randomUUID().toString();
                Cookie cookie=new Cookie(UserToken.USER_TOKEN,uuid);
                cookie.setPath("/");
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
                HttpSession session = request.getSession();
                session.setAttribute(uuid,name);
                session.setMaxInactiveInterval(60*60*60);
                return result;
            }
            return result;
        }
        return null;
    }

    @PutMapping("insert")
    public ResultBean<Customer> insert(@RequestBody Customer customer){
        Log.logger.info("LoginController开始插入参数"+customer);
        ResultBean<Customer> customerResultBean = iLoginService.saveCoustomer(customer);
        return customerResultBean;
    }
}
