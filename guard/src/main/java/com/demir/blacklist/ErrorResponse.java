package com.demir.blacklist;

import java.io.Serializable;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:21
 */
public class ErrorResponse implements Serializable {

    private final String detail;
    private final String message;

    public ErrorResponse(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public String getMessage() {
        return message;
    }

}
