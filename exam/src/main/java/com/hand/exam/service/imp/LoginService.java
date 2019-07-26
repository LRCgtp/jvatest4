package com.hand.exam.service.imp;

import com.hand.exam.dao.LoginDao;
import com.hand.exam.entity.Customer;
import com.hand.exam.service.ILoginService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public ResultBean<Customer> login(String name, String password) {
        Log.logger.info("loginservice通过name查询"+name);
        Customer customer=null;
        try {
           customer = loginDao.getCustomerByName(name);
           if (customer !=null){
               Log.logger.info("通过用户名查到对象了");
               if (customer.getLastName().equals(password)){
                   Log.logger.info("信息匹配,登录成功");
                   return new ResultBean<>(1,"登录成功",null);
               }
           }
        }catch (Exception e){
           Log.logger.error("loginservice登录出错",e.getMessage(),e.getCause());
        }
        return new ResultBean<>(0,"登录出错",null);
    }

    @Override
    public ResultBean<Customer> saveCoustomer(Customer customer) {
        Log.logger.info("loginservice开始存入用户"+customer);
        int i = loginDao.insertCustomer(customer);
        if (i>0){
            return new ResultBean<Customer>(1,"插入成功",customer);
        }
        return new ResultBean<>(0,"插入出错",null);
    }

    @Override
    public ResultBean<Customer> updateCustomer(Integer id) {

        return null;
    }


}
