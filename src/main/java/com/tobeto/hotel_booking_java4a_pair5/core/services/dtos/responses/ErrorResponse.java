package com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses;

public class ErrorResponse extends Response {
    public ErrorResponse() {
        super(false);
    }

    public ErrorResponse(String message) {
        super(false, message);
    }
}
