package com.example.demo.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FrequencyForMultiWeeksValidator.class)
public @interface ValidateFrequencyForMultiWeeks {

    String message() default "The Amount Entered is not Valid";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
