package com.example.service;

import com.example.constants.NumberNames;
import com.example.constants.SpecialNames;
import com.example.constants.TensNames;
import com.example.validator.NumberToWordValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberToWordConverterService {

    final Logger log = LoggerFactory.getLogger(NumberToWordConverterService.class);
    @Autowired
    private NumberToWordValidation validation;

    public String convertNumberToWord(String number) {
        number = validation.inputValidation(number);
        log.info("Validation success");
        return convertNumberToWord(Integer.parseInt(number));
    }

    private String convertIntoWordLessThanOneThousand(int number, int count) {
        String current;
        int inputNumber = number;

        if (modulusBy100(number) < 20) {
            //if modulus result is less than 20
            //and required only if first time and input number is greater than 100
            if(count == 0 && number > 100) {
                current = " and" + NumberNames.values()[modulusBy100(number)].getValue();
            } else {
                current = NumberNames.values()[modulusBy100(number)].getValue();
            }

            number = divisionBy100(number);
        } else {
            //if modulus result is greater than 20
            //for first number
            current = NumberNames.values()[modulusBy10(number)].getValue();
            number = divisionBy10(number);

            //for 2nd number
            //and required only if first time and input number is greater than 100
            if(count == 0 && inputNumber > 100) {
                current = " and" + TensNames.values()[modulusBy10(number)].getValue() + current;
            } else {
                current = TensNames.values()[modulusBy10(number)].getValue() + current;
            }
            number = divisionBy10(number);
        }

        if (number == 0)
            return current;

        return NumberNames.values()[number].getValue() + " hundred" + current;
    }

    private String convertNumberToWord(int number) {
        if (number == 0) {
            return "zero";
        }

        String prefix = "";
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }

        String current = "";
        int place = 0;
        do {
            int n = number % 1000;
            if (n != 0) {
                String s = convertIntoWordLessThanOneThousand(n, place);
                current = s + SpecialNames.values()[place].getValue() + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    private int modulusBy100(int number) {
        return number % 100;
    }

    private int modulusBy10(int number) {
        return number % 10;
    }

    private int divisionBy100(int number) {
        return number / 100;
    }

    private int divisionBy10(int number) {
        return number / 10;
    }

    /*public static void main(String[] a) {
        NumberToWordConverterService object = new NumberToWordConverterService();
        //nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine
        //System.out.println(object.convertNumberToWord(105));
        //System.out.println(object.convertNumberToWord(56945781));
        //System.out.println(object.convertNumberToWord("999,999,999"));
        System.out.println(object.convertNumberToWord(105));
    }*/

    public void setValidation(NumberToWordValidation validation) {
        this.validation = validation;
    }
}
