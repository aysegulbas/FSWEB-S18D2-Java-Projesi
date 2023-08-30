package com.workintech.plant.exceptions;

import com.workintech.plant.entity.Fruit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    //ilk kısım bizim kendi belirlediğimiz handler, ikinci kısım bizim entity içine yazdığımız annotationların aktivasyonu için @NotNull gibi,üçüncü kısım global (bizim case olarak düşünemediklerimiz
    public ResponseEntity<FruitResponse> handleException(FruitException fruitException){
        FruitResponse response = new FruitResponse(fruitException.value(),
                fruitException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, fruitException.getStatus());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String> errors = new HashMap<>();
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(FruitException fruitException){
        FruitResponse response = new FruitResponse(HttpStatus.BAD_REQUEST.value(), fruitException.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
