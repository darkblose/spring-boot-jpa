package com.jpabook.jpashop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "error.duplicatedMember")
public class DuplicatedMemberException extends IllegalStateException {
}
