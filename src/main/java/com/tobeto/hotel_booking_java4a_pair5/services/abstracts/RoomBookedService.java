package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetAllRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;

import java.util.List;

public interface RoomBookedService {
    Result add(AddRoomBookedRequest request);

    Result update(UpdateRoomBookedRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllRoomBookedResponse>> getAll();

    DataResult<GetByIdRoomBookedResponse> getById(Integer id);

    DataResult<List<GetByIdRoomBookedResponse>> findByBookingId(int bookingId);
}
