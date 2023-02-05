package com.jpabook.jpashop.exception.handler;

import com.jpabook.jpashop.exception.DuplicatedMemberException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DuplicatedMemberException.class)
    public ErrorResult duplicatedMember(DuplicatedMemberException e) {
        log.error("예외 발생", e);
        return new ErrorResult("BAD REQUEST", e.getMessage());
    }
}
