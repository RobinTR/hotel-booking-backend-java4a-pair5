package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomTypeRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomTypeRules {
    private final RoomTypeRepository roomTypeRepository;

    public RoomType findById(Integer id) {
        return roomTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RoomTypeMessages.ROOM_TYPE_NOT_FOUND));
    }
}
