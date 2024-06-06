package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetAllAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;

import java.util.List;

public interface AreaService {
    Result add(AddAreaRequest request);

    Result update(UpdateAreaRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllAreaResponse>> getAll();

    DataResult<GetByIdAreaResponse> getById(Integer id);
}
