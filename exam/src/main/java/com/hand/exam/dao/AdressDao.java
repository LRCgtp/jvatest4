package com.hand.exam.dao;

import com.hand.exam.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdressDao {
    Address getAddress(String address);
}
