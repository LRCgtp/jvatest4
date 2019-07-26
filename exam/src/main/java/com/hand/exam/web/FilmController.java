package com.hand.exam.web;

import com.hand.exam.entity.Film;
import com.hand.exam.entity.Page;
import com.hand.exam.entity.PageInfo;
import com.hand.exam.service.IFilmService;
import com.hand.exam.utiils.Log;
import com.hand.exam.utiils.ResultBean;
import com.hand.exam.vo.ParamModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("film")
public class FilmController {

    static final Logger logger = LoggerFactory.getLogger(FilmController.class);

    @Autowired
    private IFilmService iFilmService;

    @PostMapping("insert")
    public ResultBean<Film> insert(Film film) {
        Film film2 = new Film();
        film2.setLanguageId((byte) 1);
        film2.setOriginalLanguageId(null);
        logger.info("controller开始插入参数" + film);
        return iFilmService.saveFile(film2);
    }

    @GetMapping("list/{pageSize}/{pageNo}")
    public PageInfo<Film> list(@PathVariable("pageSize") String pageSize, @PathVariable("pageNo") String pageNo) {
        Log.logger.info("FilmController开始存入参数", pageSize, pageNo);
        PageInfo page = iFilmService.filmList(pageNo, pageSize);
        if (page != null) {
            Log.logger.info("FilmController分页成功");
            return page;
        }
        Log.logger.info("FilmController分页失败");
        return null;
    }

    @GetMapping("/getpage")
    public PageInfo queryPage(@ParamModel Page page) {

        Log.logger.info("FilmController开始存入参数"+page.getPage()+ page.getPageSize());
        PageInfo pages = iFilmService.filmList((page.getPage())+"", (page.getPageSize())+"");
        if (pages != null) {
            Log.logger.info("FilmController分页成功");
            return pages;
        }
        Log.logger.info("FilmController分页失败");
        return null;
    }
}
