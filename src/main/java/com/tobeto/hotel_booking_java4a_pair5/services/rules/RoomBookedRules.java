package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomBookedRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomBookedRules {
    private final RoomBookedRepository roomBookedRepository;

    public RoomBooked findById(Integer id) {
        return roomBookedRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RoomBookedMessages.ROOM_BOOKED_NOT_FOUND));
    }
}
