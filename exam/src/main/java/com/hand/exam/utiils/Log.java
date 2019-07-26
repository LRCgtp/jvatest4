package com.hand.exam.utiils;

import com.hand.exam.service.imp.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Log {
     Logger logger= LoggerFactory.getLogger(FilmService.class);
}
