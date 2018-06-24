package com.demir.blacklist;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * User: muratdemir
 * Date: 24.06.2018
 * Time: 12:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Documented
@Constraint(validatedBy = IpValidator.class)
public @interface Ip {

    String message() default "invalid ip address";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
