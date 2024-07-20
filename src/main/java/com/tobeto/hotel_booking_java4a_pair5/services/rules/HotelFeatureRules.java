package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelFeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelFeatureMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelFeatureRules {
    private final HotelFeatureRepository hotelFeatureRepository;

    public HotelFeature findById(Integer id) {
        return hotelFeatureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HotelFeatureMessages.HOTEL_FEATURE_NOT_FOUND));
    }
}
