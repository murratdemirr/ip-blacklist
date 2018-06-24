package com.demir.blacklist;

import org.apache.commons.validator.routines.InetAddressValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:53
 */
public class IpValidator implements ConstraintValidator<Ip, Object> {

    @Override
    public void initialize(Ip constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return InetAddressValidator.getInstance().isValid((String) value);
    }
}
