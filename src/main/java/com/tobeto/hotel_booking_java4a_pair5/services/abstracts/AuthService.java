package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.LoginRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;

public interface AuthService {
    Result register(RegisterRequest request);

    String login(LoginRequest request);
}
