package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;

import java.util.List;

public interface ManagerService {
    Result add(AddManagerRequest request);
    Result update(UpdateManagerRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllManagerResponse>> getAll();
    DataResult<GetByIdManagerResponse> getById(Integer id);
}
