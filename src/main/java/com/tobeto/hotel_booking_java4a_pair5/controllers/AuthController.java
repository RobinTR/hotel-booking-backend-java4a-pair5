package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AuthService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.LoginRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("profile")
    public DataResponse<GetByIdUserResponse> getUserProfile(@RequestParam Integer userId) {
        User user = authService.getUserProfileById(userId);
        GetByIdUserResponse response = UserMapper.INSTANCE.getByIdUserResponseFromUser(user);

        return new SuccessDataResponse<>(response);
    }
}
