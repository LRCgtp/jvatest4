package com.hand.exam.dao;

import com.hand.exam.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
    Customer getCustomerByName(String name);

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);
}
