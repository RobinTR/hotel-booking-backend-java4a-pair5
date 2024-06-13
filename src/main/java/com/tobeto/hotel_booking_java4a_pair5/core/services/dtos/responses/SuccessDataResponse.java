package com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses;

public class SuccessDataResponse<T> extends DataResponse<T> {
    public SuccessDataResponse(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResponse(T data) {
        super(data, true);
    }

    public SuccessDataResponse(String message) {
        super(null, true, message);
    }

    public SuccessDataResponse() {
        super(null, true);
    }
}
