package com.security.demo.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 用于抛出验证码错误的异常，集成AuthenticationException可被SpringSecurity捕获到
 * @author hdd
 * @date 2018/12/11 0011 14:55
 * @param
 * @return
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
