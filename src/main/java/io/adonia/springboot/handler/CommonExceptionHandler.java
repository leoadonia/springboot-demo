package io.adonia.springboot.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leo
 * @create 2018/9/9
 */
@ControllerAdvice
public class CommonExceptionHandler {

//    @ExceptionHandler
//    @ResponseBody
//    public Map<String, Object> exceptionHandler(Exception e) {
//        Map<String, Object> result = new HashMap<>();
//
//        result.put("errorCode", "11111");
//        result.put("errorMsg", e.getMessage());
//
//        return result;
//    }

    @ExceptionHandler
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.addObject("url", request.getRequestURI());
        return mv;
    }

}
