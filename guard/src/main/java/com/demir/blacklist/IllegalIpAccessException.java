package com.demir.blacklist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 13:42
 */

@ResponseStatus(HttpStatus.FORBIDDEN)
public class IllegalIpAccessException extends RuntimeException {

    public IllegalIpAccessException() {
        super();
    }

    public IllegalIpAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalIpAccessException(String message) {
        super(message);
    }

    public IllegalIpAccessException(Throwable cause) {
        super(cause);
    }

}
