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

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:20
 */
public class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(EntityNotFoundException.class)
    public
    @ResponseBody
    ErrorResponse handleResourceNotFoundException(EntityNotFoundException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("ResourceNotFoundException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "entity not found.");
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public
    @ResponseBody
    ErrorResponse handleResourceNotFoundException(EntityAlreadyExistsException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("ResourceNotFoundException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "entity already exists");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(IllegalIpAccessException.class)
    public
    @ResponseBody
    ErrorResponse handleResourceNotFoundException(IllegalIpAccessException ex, WebRequest request, HttpServletResponse response) {
        LOG.info("ResourceNotFoundException handler:" + ex.getMessage());
        return new ErrorResponse(ex, "Illegal Ip Access");
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}