package com.example.validator;

import com.example.constants.NumberWordConverterMessage;
import com.example.exception.NumberWordConverterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class NumberToWordValidation {

    final Logger log = LoggerFactory.getLogger(NumberToWordValidation.class);

    public String inputValidation(String number) {

        if (null == number || "".equals(number)) {
            log.error("Number cannot be null");
            throw new NumberWordConverterException(HttpStatus.BAD_REQUEST.value(), NumberWordConverterMessage.EMPTY_INPUT.getMessage(), NumberWordConverterMessage.EMPTY_INPUT_ERROR_CODE.getMessage());
        }

        if(number.indexOf(",") != -1) {
            number = number.replaceAll(",", "");
        }

        try {
            log.info("Input value is: {}", number);
            Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            log.error("Exception occurs during parsing number: {}", number);
            log.error("Exception details: {}", ex.fillInStackTrace());
            throw new NumberWordConverterException(HttpStatus.BAD_REQUEST.value(), NumberWordConverterMessage.INVALID_INPUT.getMessage(), NumberWordConverterMessage.INVALID_INPUT_ERROR_CODE.getMessage());
        }

        return number;
    }
}
