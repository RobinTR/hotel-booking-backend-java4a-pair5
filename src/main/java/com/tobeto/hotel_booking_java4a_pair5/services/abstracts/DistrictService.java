package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetAllDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetByIdDistrictResponse;

import java.util.List;


public interface DistrictService {
    Result add(AddDistrictRequest request);

    Result update(UpdateDistrictRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllDistrictResponse>> getAll();

    DataResult<GetByIdDistrictResponse> getById(Integer id);
}
