package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CountryRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CountryMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryRules {
    private final CountryRepository countryRepository;

    public Country findById(Integer id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CountryMessages.COUNTRY_NOT_FOUND));
    }
}
