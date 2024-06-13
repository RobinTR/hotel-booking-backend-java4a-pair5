package com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response {
    private final boolean success;
    private String message;

    public Response(boolean success) {
        super();
        this.success = success;
    }
}
