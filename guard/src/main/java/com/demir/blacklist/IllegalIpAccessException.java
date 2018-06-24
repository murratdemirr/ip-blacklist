package com.demir.blacklist;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 13:42
 */
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
