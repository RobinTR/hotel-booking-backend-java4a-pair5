package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;

import java.util.List;


public interface CountryService {
    Country add(AddCountryRequest request);

    Country update(UpdateCountryRequest request);

    String delete(Integer id);

    List<Country> getAll();

    Country getById(Integer id);
}
