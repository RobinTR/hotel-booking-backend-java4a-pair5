package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;

import java.util.List;

public interface NeighborhoodService {

    Result add(AddNeighborhoodRequest request);

    Result update(UpdateNeighborhoodRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllNeighborhoodResponse>> getAll();

    DataResult<GetByIdNeighborhoodResponse> getById(Integer id);
}
