package com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomIODetails extends ProblemDetails {
    public CustomIODetails(String detail) {
        setDetail(detail);
        setTitle("Input/Output Error");
        setType("CustomIOException");
    }
}
