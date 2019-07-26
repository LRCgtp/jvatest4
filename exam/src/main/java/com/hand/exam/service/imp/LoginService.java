package com.hand.exam.service.imp;

import com.hand.exam.dao.LoginDao;
import com.hand.exam.entity.Address;
import com.hand.exam.entity.Customer;
import com.hand.exam.service.IAdressService;
import com.hand.exam.service.ILoginService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private IAdressService iAdressService;

    @Override
    public ResultBean<Customer> login(String name, String password) {
        Log.logger.info("loginservice通过name查询"+name);
        String last_name=null;
        try {
           last_name = loginDao.getCustomerByName(name);
           if (last_name !=null){
               Log.logger.info("通过用户名查到对象了"+last_name);
               if (last_name.equals(password)){
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
            Log.logger.info("Custormer插入成功");
            return new ResultBean<Customer>(1,"插入成功",customer);
        }
        return new ResultBean<>(0,"插入出错",null);
    }

    @Override
    public ResultBean<Customer> updateCustomer(Short id) {
        Customer customer=new Customer();
      Log.logger.info("LoginService开始跟新操作");
        int i = loginDao.updateCustomer(id);
        Log.logger.info("返回值"+id);
        if (i==0){
            return new ResultBean<>(0,"更新出错",null);
        }
        return new ResultBean<Customer>(1,"更新成功",customer);
    }

    @Override
    public ResultBean<Customer> delteCustomer(Short id) {
        Log.logger.info("LoginService开始删除用户操作");
        int i = loginDao.deleteCustomer(id);
        if (i>0){
            return new ResultBean<Customer>(1,"删除成功",null);
        }
        return new ResultBean<>(0,"插入出错",null);
    }


}
