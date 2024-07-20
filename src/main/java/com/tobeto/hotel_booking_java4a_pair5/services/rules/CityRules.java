package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CityRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CityMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityRules {
    private final CityRepository cityRepository;

    public City findById(Integer id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CityMessages.CITY_NOT_FOUND));
    }
}
