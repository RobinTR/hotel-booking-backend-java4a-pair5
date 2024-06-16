package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;

import java.util.List;

public interface RoomTypeService {
    RoomType add(AddRoomTypeRequest request);

    RoomType update(UpdateRoomTypeRequest request);

    String delete(Integer id);

    List<RoomType> getAll();

    RoomType getById(Integer id);
}
