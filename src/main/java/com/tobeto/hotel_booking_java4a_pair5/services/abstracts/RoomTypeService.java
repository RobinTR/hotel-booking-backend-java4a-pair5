package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.*;

import java.util.List;

public interface RoomTypeService {
    Result add(AddRoomTypeRequest request);
    Result update(UpdateRoomTypeRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllRoomTypeResponse>> getAll();
    DataResult<GetByIdRoomTypeResponse> getById(Integer id);
}
