package com.hand.exam.web;

import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.service.IFilmService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("film")
public class FilmController {

    static final Logger logger= LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private IFilmService iFilmService;

    @PostMapping("insert")
    public ResultBean<Film> insert(Film film){
        Film film2=new Film();
        film2.setDescription("你好");
        film2.setFilmId((short)5);
        film2.setLanguageId(null);
        film2.setTitle("你好");
        film2.setReleaseYear(null);
        film2.setOriginalLanguageId(null);
        film2.setRentalDuration((byte)7);
        film2.setRentalRate(new BigDecimal(8.0));
        film2.setLength(null);
        film2.setReplacementCost(new BigDecimal(8.0));
        film2.setRating(null);
        film2.setSpecialFeatures(null);
        film2.setLastUpdate(new Date());
        logger.info("controller开始插入参数"+film);
        return iFilmService.saveFile(film2);
    }

    @GetMapping("list/{pageSize}/{pageNo}")
    public Page<Film> list(@PathVariable("pageSize") String pageSize,@PathVariable("pageNo") String pageNo){
        Log.logger.info("FilmController开始存入参数",pageSize,pageNo);
        Page page = iFilmService.filmList(pageNo, pageSize);
        if (page !=null){
            Log.logger.info("FilmController分页成功");
            return page;
        }
        Log.logger.info("FilmController分页失败");
        return null;
    }
}
