package com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses;

public class SuccessResponse extends Response {
    public SuccessResponse() {
        super(true);
    }

    public SuccessResponse(String message) {
        super(true, message);
    }
}
