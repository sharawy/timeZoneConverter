package com.timeZone.validators;

import com.timeZone.validators.annotations.StringTimeDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringTimeDateValidator implements ConstraintValidator<StringTimeDate, String> {
    private String format;
    @Override
    public void initialize(StringTimeDate constraintAnnotation) {
        this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String dateToValidate, ConstraintValidatorContext cxt) {

        if (dateToValidate == null) {
            return false;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(this.format);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

}
