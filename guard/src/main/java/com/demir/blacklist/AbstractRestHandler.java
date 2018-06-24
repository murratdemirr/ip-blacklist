package com.demir.blacklist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:20
 */
public class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;



    @ExceptionHandler(EntityNotFoundException.class)
    public
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    ErrorResponse entityNotFound(EntityNotFoundException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("EntityNotFoundException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "entity not found.");
    }


    @ExceptionHandler(EntityAlreadyExistsException.class)
    public
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    ErrorResponse entityAlreadyExists(EntityAlreadyExistsException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("EntityAlreadyExistsException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "entity already exists");
    }


    @ExceptionHandler(IllegalIpAccessException.class)
    public
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    ErrorResponse IllegalIpAccess(IllegalIpAccessException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("IllegalIpAccessException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "Illegal Ip Access");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}