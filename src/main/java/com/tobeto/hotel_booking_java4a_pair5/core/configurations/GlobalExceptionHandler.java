package com.tobeto.hotel_booking_java4a_pair5.core.configurations;


import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails.BusinessProblemDetails;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails.CustomIODetails;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails.ResourceNotFoundDetails;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails.ValidationProblemDetails;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.CustomIOException;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException exception) {
        return new BusinessProblemDetails(exception.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResourceNotFoundDetails handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResourceNotFoundDetails(exception.getMessage());
    }

    @ExceptionHandler({CustomIOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomIODetails handleResourceNotFoundException(IOException exception) {
        return new CustomIODetails(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage()
                ));

        return new ValidationProblemDetails(validationErrors);
    }
}
