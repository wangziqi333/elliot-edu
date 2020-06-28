package com.elliot.apiedu.exhandle;

import com.elliot.commutils.util.ExceptionUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理器.
 */
@RestControllerAdvice
public class EduExceptionHandler {


    /**
     * 啥异常都接, 不知会不会影响事务.
     * <p>
     *     接住异常以后，异常就由我们控制了.
     * </p>
     */
    @ExceptionHandler(Exception.class)
    public String handle(Exception ex){

        String message = ExceptionUtil.getMessage(ex);

        System.out.println("-----------------");

        System.out.println(message);

        System.out.println("-----------------");

        return "出现了问题，请联系管理员.具体问题："+ex.getMessage();
    }


}
