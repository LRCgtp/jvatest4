package com.hand.exam.service.imp;

import com.hand.exam.dao.AdressDao;
import com.hand.exam.entity.Address;
import com.hand.exam.service.IAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService implements IAdressService {

    @Autowired
    private AdressDao adressDao;


    @Override
    public Address getAdressByAddress(String address) {
        return adressDao.getAddress(address);
    }
}
