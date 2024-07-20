package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AreaRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AreaMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AreaRules {
    private final AreaRepository areaRepository;

    public Area findById(Integer id) {
        return areaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AreaMessages.AREA_NOT_FOUND));
    }
}
