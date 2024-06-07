package com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    private List<String> errors;

    public ValidationProblemDetails(List<String> errors) {
        setDetail("One or more validation error(s)!");
        setType("ValidationException");
        setTitle("Validation Rule Violation");
        this.errors = errors;
    }
}
