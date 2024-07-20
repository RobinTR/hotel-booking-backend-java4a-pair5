package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.FeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.FeatureMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureRules {
    private final FeatureRepository featureRepository;

    public Feature findById(Integer id) {
        return featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(FeatureMessages.FEATURE_NOT_FOUND));
    }
}
