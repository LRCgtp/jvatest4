package com.hand.exam.service;

import com.hand.exam.entity.Customer;
import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.utiils.ResultBean;

public interface IFilmService {
    ResultBean<Film> saveFile(Film film);

    Page filmList(String pageno,String pagesize);

}
