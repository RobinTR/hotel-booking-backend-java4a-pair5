package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeatureMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomFeatureRules {
    private final RoomFeatureRepository roomFeatureRepository;

    public RoomFeature findById(Integer id) {
        return roomFeatureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RoomFeatureMessages.ROOM_FEATURE_NOT_FOUND));
    }
}
