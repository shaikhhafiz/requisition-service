package com.hafiz.erp.requisition.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class ValidDateFormatValidator implements ConstraintValidator<ValidDateFormat, Date> {

  @Override
  public void initialize(ValidDateFormat constraintAnnotation) {

  }

  @Override
  public boolean isValid(Date value, ConstraintValidatorContext context) {
    //TODO Implement date format validation
    return value != null;
  }
}
