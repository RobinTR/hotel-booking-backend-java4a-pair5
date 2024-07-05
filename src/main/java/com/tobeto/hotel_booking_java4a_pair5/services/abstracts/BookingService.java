package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking add(AddBookingRequest request);

    Booking update(UpdateBookingRequest request);

    String delete(Integer id);

    List<Booking> getAll();

    Booking getById(Integer id);

    List<Booking> searchByDate(LocalDate startDate, LocalDate endDate);

    List<Booking> searchByRoomType(Integer roomTypeId);

    Booking changeCheckInDate(Integer id);

    Booking changeCheckOutDate(Integer id);

    Booking changeReservationStatus(Integer id, ReservationStatus reservationStatus);

    List<Booking> getBookingsByUserId(Integer userId);
}
