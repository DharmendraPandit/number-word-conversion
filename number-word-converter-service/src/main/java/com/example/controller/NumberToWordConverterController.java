package com.example.controller;

import com.example.exception.NumberWordConverterException;
import com.example.service.NumberToWordConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/word")
public class NumberToWordConverterController {

    @Autowired
    private NumberToWordConverterService service;

    @ExceptionHandler(NumberWordConverterException.class)
    void handleUserException(NumberWordConverterException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @GetMapping
    public ResponseEntity<?> numberToWordConverter(@RequestParam("number") String number) {
        return new ResponseEntity<>(service.convertNumberToWord(number), HttpStatus.OK);
    }
}
