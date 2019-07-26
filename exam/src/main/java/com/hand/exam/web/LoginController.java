package com.hand.exam.web;

import com.hand.exam.entity.Address;
import com.hand.exam.entity.Customer;
import com.hand.exam.service.IAdressService;
import com.hand.exam.service.ILoginService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import com.hand.exam.utiils.UserToken;
import com.hand.exam.vo.Change;
import com.hand.exam.vo.VoAdress;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private ILoginService iLoginService;

    @Autowired
    private IAdressService iAdressService;

    Change change=new Change();

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
    public ResultBean insert(@RequestBody Customer customer){
        Log.logger.info("LoginController开始插入参数"+customer);
        customer.setStoreId((byte)1);
        ResultBean<Customer> customerResultBean= customerResultBean=iLoginService.saveCoustomer(customer);
        Short id=null;
        if (customerResultBean.getT() !=null){
            Log.logger.info("主键回填"+customer);
           change.setCustom_id(customerResultBean.getT().getCustomerId());
           Log.logger.info("chang为"+change.toString());
           return customerResultBean;
        }
        return customerResultBean;
    }

    @PostMapping("update")
    public ResultBean<Customer> update(){
        short id=0;
        if (change !=null){
             id=change.getCustom_id();
        }
        Log.logger.info("LoginController开始跟新参数"+id+change);
        ResultBean<Customer> customerResultBean = iLoginService.updateCustomer(id);
        return customerResultBean;
    }

    @DeleteMapping("delete")
    public ResultBean<Customer> delete(){
        short id=0;
        if (change !=null){
            id=change.getCustom_id();
        }
        Log.logger.info("LoginController开始删除"+id,change);
        ResultBean<Customer> customerResultBean = iLoginService.delteCustomer(id);
        return customerResultBean;
    }

}
