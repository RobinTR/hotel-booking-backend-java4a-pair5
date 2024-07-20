package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.repositories.GuestRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestRules {
    private final GuestRepository guestRepository;

    public Guest findById(Integer id) {
        return guestRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(GuestMessages.GUEST_NOT_FOUND));
    }
}
