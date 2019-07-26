package com.hand.exam.dao;

import com.hand.exam.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginDao {
    String getCustomerByName(String name);

    int insertCustomer(Customer customer);

    int updateCustomer(Short id);

    int deleteCustomer(Short id);
}
