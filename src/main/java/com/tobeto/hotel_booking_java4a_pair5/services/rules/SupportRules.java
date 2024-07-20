package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.repositories.SupportRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupportRules {
    private final SupportRepository supportRepository;

    public Support findById(Integer id) {
        return supportRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(SupportMessages.SUPPORT_NOT_FOUND));
    }
}
