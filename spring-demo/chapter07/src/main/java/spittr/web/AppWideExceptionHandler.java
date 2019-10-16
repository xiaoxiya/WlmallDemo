package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.exception.DuplicateSpittleException;

/**
 * @author luopeng
 * @date 2019/10/16 23:48
 * 为所有控制器处理异常
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    /**
     * 定义异常处理方法
     * @return
     */
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDulicateSpittle() {
        return "error/duplicate";
    }
}
