package com.tobeto.hotel_booking_java4a_pair5.core.result;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success) {
        super();
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}