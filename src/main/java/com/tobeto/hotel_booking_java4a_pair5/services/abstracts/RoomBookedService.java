package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;

import java.util.List;

public interface RoomBookedService {
    RoomBooked add(AddRoomBookedRequest request);

    RoomBooked update(UpdateRoomBookedRequest request);

    String delete(Integer id);

    List<RoomBooked> getAll();

    RoomBooked getById(Integer id);

    List<RoomBooked> findByBooking(Booking booking);
}
