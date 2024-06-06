package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetAllCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetByIdCountryResponse;

import java.util.List;


public interface CountryService {
    Result add(AddCountryRequest request);

    Result update(UpdateCountryRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllCountryResponse>> getAll();

    DataResult<GetByIdCountryResponse> getById(Integer id);
}
