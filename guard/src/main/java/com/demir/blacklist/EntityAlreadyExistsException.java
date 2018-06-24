package com.demir.blacklist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:02
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException() {
        super();
    }

    public EntityAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }

    public EntityAlreadyExistsException(Throwable cause) {
        super(cause);
    }

}
