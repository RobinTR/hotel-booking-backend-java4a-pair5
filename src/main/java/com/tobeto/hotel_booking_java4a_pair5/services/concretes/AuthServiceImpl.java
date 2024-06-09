package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.core.services.JwtService;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Person;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PersonRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AuthService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AuthMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.LoginRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AuthMapper;
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
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public Result register(RegisterRequest request) {
        Person person = AuthMapper.INSTANCE.personFromRegisterRequest(request);
        person.setPassword(passwordEncoder.encode(request.getPassword()));
        personRepository.save(person);

        return new SuccessResult(AuthMessages.AUTH_REGISTER_SUCCESS);
    }

    @Override
    public String login(LoginRequest request) {
        Person person = personRepository.findByEmail(request.getEmail()).orElseThrow(() -> new BusinessException(AuthMessages.AUTH_WRONG_CREDENTIALS));

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        if (!authentication.isAuthenticated()) {
            throw new BusinessException(AuthMessages.AUTH_WRONG_CREDENTIALS);
        }

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("UserId", person.getId());

        return jwtService.generateToken(person.getUsername(), extraClaims);
    }
}
