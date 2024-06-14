package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomBookedRepository extends JpaRepository<RoomBooked, Integer> {
    List<RoomBooked> findByBooking(Booking booking);
}
