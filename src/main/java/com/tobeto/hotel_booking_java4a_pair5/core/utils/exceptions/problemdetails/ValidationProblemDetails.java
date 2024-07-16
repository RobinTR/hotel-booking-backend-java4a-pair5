package com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private Map<String, String> errors;

    public ValidationProblemDetails(Map<String, String> errors) {
        setTitle("Validation Rule Violation");
        setDetail("One or more validation error(s)!");
        setType("ValidationException");
        this.errors = errors;
    }
}
