package com.example.service;

import com.example.constants.NumberWordConverterMessage;
import com.example.exception.NumberWordConverterException;
import com.example.validator.NumberToWordValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class NumberToWordConverterServiceTest {
    @InjectMocks
    private NumberToWordConverterService service;

    //@Mock
    private NumberToWordValidation validation;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service.setValidation(new NumberToWordValidation());
    }

    @Test
    public void convertNumberToWord_failedForEmptyInput() {
        String inputNumber = null;
        //when(validation.inputValidation(number)).thenThrow(NumberWordConverterException.class);
        //service.convertNumberToWord(number);
        /*assertThrows(NumberWordConverterException.class, () -> {
            service.convertNumberToWord(number);
        });*/

        Exception exception = assertThrows(
                NumberWordConverterException.class,
                () -> service.convertNumberToWord(inputNumber)
        );
        assertTrue(exception.getMessage().contains(NumberWordConverterMessage.EMPTY_INPUT.getMessage()));
        assertEquals(exception.getMessage(), NumberWordConverterMessage.EMPTY_INPUT.getMessage());
    }

    @Test
    public void convertNumberToWord_failedForInvalidInput() {
        String inputNumber = "123a";
        Exception exception = assertThrows(
                NumberWordConverterException.class,
                () -> service.convertNumberToWord(inputNumber)
        );
        assertTrue(exception.getMessage().contains(NumberWordConverterMessage.INVALID_INPUT.getMessage()));
        assertEquals(exception.getMessage(), NumberWordConverterMessage.INVALID_INPUT.getMessage());
    }

    @Test
    public void convertNumberToWord_successWithPositiveInput() {
        String inputNumber = "12345";
        String actualResult = "twelve thousand three hundred and forty five";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void convertNumberToWord_successWithNegativeInput() {
        String inputNumber = "-12345";
        String actualResult = "negative twelve thousand three hundred and forty five";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void convertNumberToWord_successWith0Value() {
        String inputNumber = "0";
        String actualResult = "zero";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void convertNumberToWord_successWithLessThan20() {
        String inputNumber = "19";
        String actualResult = "nineteen";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void convertNumberToWord_successWithGreaterThan20() {
        String inputNumber = "21";
        String actualResult = "twenty one";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void convertNumberToWord_successWithCommaSeperatedInput() {
        String inputNumber = "999,999,999";
        String actualResult = "nine hundred ninety nine million nine hundred ninety nine thousand nine hundred and ninety nine";
        String expectedResult = service.convertNumberToWord(inputNumber);
        assertEquals(expectedResult, actualResult);
    }

}
