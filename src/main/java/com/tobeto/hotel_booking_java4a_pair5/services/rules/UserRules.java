package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.repositories.UserRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.UserMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRules {
    private final UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(UserMessages.USER_NOT_FOUND));
    }
}
