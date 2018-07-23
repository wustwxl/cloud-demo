package com.wust.exception;

import com.wust.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: F7687967
 * @date: 2017/10/16
 * @time: 下午 04:05
 * @description: 统一异常处理, 通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 拦截捕捉自定义异常 MyException.class
    @ExceptionHandler(value = MyException.class)
    public ExceptionResponse jsonErrorHandler(MyException ex) throws Exception {

        String debug = StringUtil.getStringRandom(12);
        //打印12位随机字符串,用于日至搜索。
        logger.error("------------DEBUG : " + debug);

        ExceptionResponse response = new ExceptionResponse();
        response.setCode(ExceptionResponse.ERROR);
        response.setInfo("Failed");
        response.setData(ex.getMessage());
        response.setDebug(debug);
        return response;
    }

    //全局异常捕捉处理
    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse errorHandler(Exception ex) {

        String debug = StringUtil.getStringRandom(12);
        //打印12位随机字符串,用于日至搜索。
        logger.error("------------DEBUG : " + debug);

        ExceptionResponse response = new ExceptionResponse();
        response.setCode(ExceptionResponse.ERROR);
        response.setInfo("Failed");
        response.setData(ex.getMessage());
        response.setDebug(debug);
        return response;
    }

}