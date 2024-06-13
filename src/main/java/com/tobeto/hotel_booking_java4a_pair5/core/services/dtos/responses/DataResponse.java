package com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses;

import lombok.Getter;

@Getter
public class DataResponse<T> extends Response {
    private final T data;

    public DataResponse(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResponse(T data, boolean success) {
        super(success);
        this.data = data;
    }
}
