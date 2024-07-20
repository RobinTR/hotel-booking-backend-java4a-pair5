package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.repositories.NeighborhoodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.NeighborhoodMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NeighborhoodRules {
    private final NeighborhoodRepository neighborhoodRepository;

    public Neighborhood findById(Integer id) {
        return neighborhoodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NeighborhoodMessages.NEIGHBORHOOD_NOT_FOUND));
    }
}
