package com.breadcrumbdata.auth_server.controller;

import com.breadcrumbdata.auth_server.exception.UsernameNotMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UsernameNotMatchException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Map<String,Object> handleUsernameNotMatchException(UsernameNotMatchException ex) {
        Map<String, Object> result = new HashMap<>();
        result.put("username", ex.getUsername());
        result.put("query username",ex.getQueryUsername());
        result.put("message",ex.getMessage());
        return result;
    }
}
