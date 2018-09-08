package com.renguangli.rportal;

import com.renguangli.rportal.pojo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 *  全局异常处理
 * Created by renguangli at 2018/9/8 22:56
 * @since JDK1.8
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e) {
        return new Result(4000, e.getMessage());
    }
}
