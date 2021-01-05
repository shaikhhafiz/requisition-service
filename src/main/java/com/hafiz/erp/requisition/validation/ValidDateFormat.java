package com.hafiz.erp.requisition.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ValidDateFormatValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface ValidDateFormat {
  String message() default "Provided oid is invalid";
  Class<?>[] groups() default {};
  Class<? extends Payload> [] payload() default {};
}
