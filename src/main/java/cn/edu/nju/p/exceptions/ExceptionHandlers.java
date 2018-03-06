package cn.edu.nju.p.exceptions;

import cn.edu.nju.p.dto.BaseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pc on 2018/3/6.
 */
//@ControllerAdvice
//@Component
//@ResponseBody
//public class ExceptionHandlers {
//
//    @ExceptionHandler(MySQLIntegrityConstraintViolationException.class)
//    public BaseResult handleConstraintViolationException(MySQLIntegrityConstraintViolationException e){
//        return new BaseResult<>(90000001,"存在重复！");
//    }
//}
