package info.chen.smallcrud.controller;

import info.chen.smallcrud.exception.UserNotFoundException;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    /**
     * 无论是浏览器请求还是 postman 请求都是一样，都返回 json
     * 这样没有做到自适应
     */
    /*@ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, Object> handlerUserNotFoundException(Exception e) {

        Map<String, Object> map = new HashMap<>();
        map.put("code", "user not exist");
        map.put("message", e.getMessage());

        return map;
    }*/

    @ExceptionHandler(UserNotFoundException.class)
    public String handlerUserNotFoundException(Exception e, HttpServletRequest request) {

        // 设置返回HTTP状态码
//        request.setAttribute("javax.servlet.error.status_code", HttpStatus.BAD_REQUEST.value());
        request.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR.value());

        Map<String, Object> map = new HashMap<>();
        map.put("message", "用户不存在");

        request.setAttribute("extension", map);
        return "forward:/error";
    }
}
