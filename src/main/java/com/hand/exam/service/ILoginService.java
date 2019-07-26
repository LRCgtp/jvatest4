package com.hand.exam.service;

import com.hand.exam.entity.Customer;
import com.hand.exam.utiils.ResultBean;

public interface ILoginService {
    ResultBean<Customer> login(String name,String password);

    ResultBean<Customer> saveCoustomer(Customer customer);


    ResultBean<Customer> updateCustomer(Integer id);
}
