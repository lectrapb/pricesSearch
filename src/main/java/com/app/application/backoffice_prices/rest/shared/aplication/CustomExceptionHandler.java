package com.app.application.backoffice_prices.rest.shared.aplication;


import com.app.src.shared.domain.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<Map<String, Object>> handlerConflict(BusinessException ex,
                                                       WebRequest request){
        Map<String,Object>  responseError = new HashMap<>();
        responseError.put("error",ExceptionService.getErrorMessage(ex.getMessage()));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(responseError);
    }
}
