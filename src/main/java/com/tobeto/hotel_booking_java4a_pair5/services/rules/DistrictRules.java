package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.repositories.DistrictRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.DistrictMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistrictRules {
    private final DistrictRepository districtRepository;

    public District findById(Integer id) {
        return districtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(DistrictMessages.DISTRICT_NOT_FOUND));
    }
}
