package com.hand.exam.service;

import com.hand.exam.entity.Film;
import com.hand.exam.entity.PageInfo;
import com.hand.exam.utiils.ResultBean;

public interface IFilmService {
    ResultBean<Film> saveFile(Film film);

    PageInfo filmList(String pageno, String pagesize);

}
