package com.hand.exam.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.exam.dao.FilmDao;
import com.hand.exam.entity.Customer;
import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.service.IFilmService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService implements IFilmService {

    static final Logger logger= LoggerFactory.getLogger(FilmService.class);
    @Autowired
    private FilmDao filmDao;

    @Override
    public ResultBean<Film> saveFile(Film film) {
        logger.info("service开始插入一条数据"+film.toString());
        try {
            int i = filmDao.insertFilm(film);
            if (i>0){
                logger.info("service插入数据成功了");
                return new ResultBean<>(1,"插入数据成功",null);
            }
        }catch (Exception e){
           logger.error("service插入数据失败",e.getMessage(),e.getCause());
        }
        return new ResultBean<>(0,"插入数据失败",null);
    }

    @Override
    public Page filmList(String pageNo,String pageSieze) {
        Log.logger.info("插入分页参数",pageNo,pageSieze);
        PageHelper.startPage(Integer.parseInt(pageNo),Integer.parseInt(pageSieze));
        List<Film> films = filmDao.getFilms();
        Log.logger.info(films.toString());
        Integer count=filmDao.getCount();
        Page<Film> pageInfo=new Page<>();
        pageInfo.setCount(count);
        Integer pageCount;
        Integer paesize=Integer.parseInt(pageSieze);
        Integer pageno=Integer.parseInt(pageNo);
        if (count % paesize ==0){
            pageCount=count / paesize;
        } else {
            pageCount=count / paesize + 1;
        }
        pageInfo.setPage(pageCount);
        pageInfo.setPageNo(pageno);
        pageInfo.setT(films);
        Log.logger.info("分页操作成功");
        return pageInfo;
    }

}

