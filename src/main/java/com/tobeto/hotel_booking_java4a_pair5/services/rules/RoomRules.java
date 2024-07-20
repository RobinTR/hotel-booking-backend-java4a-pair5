package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomRules {
    private final RoomRepository roomRepository;

    public Room findById(Integer id) {
        return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RoomMessages.ROOM_NOT_FOUND));
    }
}
