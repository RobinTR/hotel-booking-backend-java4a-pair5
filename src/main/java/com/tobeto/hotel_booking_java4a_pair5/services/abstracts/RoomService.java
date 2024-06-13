package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;

import java.util.List;

public interface RoomService {
    Room add(AddRoomRequest request);

    Room update(UpdateRoomRequest request);

    String delete(Integer id);

    List<Room> getAll();

    Room getById(Integer id);
}
