package com.example.demo.annotations;

import com.example.demo.model.Frequency;
import com.example.demo.model.RegularAmount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class FrequencyForMultiWeeksValidator implements ConstraintValidator<ValidateFrequencyForMultiWeeks, RegularAmount> {

    @Override
    public void initialize(ValidateFrequencyForMultiWeeks constraintAnnotation) {

    }

    @Override
    public boolean isValid(RegularAmount regularAmount, ConstraintValidatorContext constraintValidatorContext) {
        String stringAmount = regularAmount.getAmount();
        int totalAmountInPences;

        if (regularAmount.getFrequency() != Frequency.MONTH || regularAmount.getFrequency() != Frequency.WEEK) {
            try {
                totalAmountInPences = new BigDecimal(stringAmount).multiply(new BigDecimal(100)).intValue();

            } catch (NumberFormatException e) {
                return false;
            }

            return totalAmountInPences % regularAmount.getFrequency().getFrequencyNumber() == 0;

        }

        return true;
    }
}

