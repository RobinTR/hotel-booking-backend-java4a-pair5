package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.JwtService;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.repositories.UserRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AuthService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AuthMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.LoginRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestForRegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.AddUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final GuestService guestService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public Response register(RegisterRequest request) {
        AddUserRequest addUserRequest = UserMapper.INSTANCE.addUserRequestFromAddUserRequest(request);
        addUserRequest.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = userService.add(addUserRequest);

        AddGuestForRegisterRequest guestRequest = GuestMapper.INSTANCE.addGuestForRegisterRequestFromUser(user);
        guestService.add(guestRequest);

        return new SuccessResponse(AuthMessages.AUTH_REGISTER_SUCCESS);
    }

    @Override
    public String login(LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if (!authentication.isAuthenticated()) {
            throw new BusinessException(AuthMessages.AUTH_WRONG_CREDENTIALS);
        }

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", user.getId());
        extraClaims.put("guestId", user.getGuest().getId());
        extraClaims.put("managerId", user.getManager().getId());
        extraClaims.put("roles", user.getAuthorities());

        return jwtService.createToken(user.getUsername(), extraClaims);
    }

    @Override
    public User getUserProfileById(Integer id) {
        return userService.getById(id);
    }
}
