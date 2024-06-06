package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.*;

import java.util.List;

public interface RoomService {
    Result add(AddRoomRequest request);
    Result update(UpdateRoomRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllRoomResponse>> getAll();
    DataResult<GetByIdRoomResponse> getById(Integer id);
}
