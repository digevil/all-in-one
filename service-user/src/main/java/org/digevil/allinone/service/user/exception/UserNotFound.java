package org.digevil.allinone.service.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: toni
 * @date: 2020/9/5 11:38 下午
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user not found")
public class UserNotFound extends RuntimeException {
}
