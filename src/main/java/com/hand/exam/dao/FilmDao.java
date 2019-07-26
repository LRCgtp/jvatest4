package com.hand.exam.dao;

import com.hand.exam.entity.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilmDao {
    int insertFilm(Film film);

    List<Film> getFilms();

    Integer getCount();
}
