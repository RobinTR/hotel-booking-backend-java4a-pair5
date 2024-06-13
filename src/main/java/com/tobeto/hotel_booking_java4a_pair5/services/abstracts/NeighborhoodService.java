package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;

import java.util.List;

public interface NeighborhoodService {

    Response add(AddNeighborhoodRequest request);

    Response update(UpdateNeighborhoodRequest request);

    Response delete(Integer id);

    DataResponse<List<GetAllNeighborhoodResponse>> getAll();

    DataResponse<GetByIdNeighborhoodResponse> getById(Integer id);
}
