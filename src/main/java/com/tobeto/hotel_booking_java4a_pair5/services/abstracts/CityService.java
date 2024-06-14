package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;

import java.util.List;

public interface CityService {
    City add(AddCityRequest request);

    City update(UpdateCityRequest request);

    String delete(Integer id);

    List<City> getAll();

    City getById(Integer id);
}
