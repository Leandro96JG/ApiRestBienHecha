package com.services.ms.product.product_service.controller;

import com.services.ms.product.product_service.exceptions.CategoryNotFoundException;
import com.services.ms.product.product_service.exceptions.ProductNotFoundExceptions;
import com.services.ms.product.product_service.model.errors.ErrorResponse;
import com.services.ms.product.product_service.utils.ErrorCatalog;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.services.ms.product.product_service.utils.ErrorCatalog.CATEGORY_NOT_FOUND;
import static com.services.ms.product.product_service.utils.ErrorCatalog.PRODUCT_NOT_FOUND;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundExceptions.class)
    public ErrorResponse handlerProductNotFoundException(){
     return ErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .message(PRODUCT_NOT_FOUND.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handlerCategoryNotFoundException(){
     return ErrorResponse.builder()
                .code(CATEGORY_NOT_FOUND.getCode())
                .message(CATEGORY_NOT_FOUND.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
