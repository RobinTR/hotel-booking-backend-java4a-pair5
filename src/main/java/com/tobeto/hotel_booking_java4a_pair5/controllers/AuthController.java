package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AuthService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.LoginRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public DataResponse<String> login(@RequestBody LoginRequest request) {
        return new SuccessDataResponse<>(authService.login(request), "true");
    }

    @PostMapping("register")
    public void register(@RequestBody RegisterRequest request) {
        authService.register(request);
    }
}
