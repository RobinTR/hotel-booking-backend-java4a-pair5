package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetAllCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetByIdCityResponse;

import java.util.List;

public interface CityService {
    Result add(AddCityRequest request);

    Result update(UpdateCityRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllCityResponse>> getAll();

    DataResult<GetByIdCityResponse> getById(Integer id);
}
