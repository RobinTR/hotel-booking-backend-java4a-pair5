package com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.problemdetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundDetails extends ProblemDetails {
    public ResourceNotFoundDetails(String detail) {
        setDetail(detail);
        setTitle("Not Found");
        setType("ResourceNotFoundException");
    }
}
