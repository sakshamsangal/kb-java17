package com.example.demo.xsd_validation;

import lombok.*;
import org.springframework.context.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

@RestControllerAdvice
@RequiredArgsConstructor
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;



    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllException(final Exception e) {
        ApiError apiError = new ApiError();
        apiError.setCode("500 INTERNAL_SERVER_ERROR");
        apiError.addMessage(e.getMessage());
        return ResponseEntity.internalServerError().body(apiError);
    }

    @ExceptionHandler(XSDValidationFailed.class)
    public ResponseEntity<ApiError> xSDValidationFailed(final XSDValidationFailed e) {
        ApiError apiError = new ApiError();
        apiError.setCode("500 XSD_VALIDATION_FAILED");
        e.getMsg().forEach(apiError::addMessage);
        return ResponseEntity.internalServerError().body(apiError);
    }
}
