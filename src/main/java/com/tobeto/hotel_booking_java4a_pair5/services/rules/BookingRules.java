package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingRules {
    private final BookingRepository bookingRepository;

    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(BookingMessages.BOOKING_NOT_FOUND));
    }

    public void validateReservationStatusChange(Booking booking, ReservationStatus reservationStatus) {
        if (reservationStatus.equals(ReservationStatus.APPROVED)) {
            booking.setReservationStatus(ReservationStatus.APPROVED);
        } else if (reservationStatus.equals(ReservationStatus.ABORTED)) {
            booking.setReservationStatus(ReservationStatus.ABORTED);
        } else if (reservationStatus.equals(ReservationStatus.COMPLETED)) {
            booking.setReservationStatus(ReservationStatus.COMPLETED);
        }
    }

    public void validateCheckInDateChange(Booking booking) {
        booking.setCheckInDate(LocalDateTime.now());
    }

    public void validateCheckOutDateChange(Booking booking) {
        booking.setCheckOutDate(LocalDateTime.now());
        booking.setReservationStatus(ReservationStatus.COMPLETED);
    }

    public void validateDeleteBooking(Booking booking) {
        if (booking.getReservationStatus() != ReservationStatus.APPROVED) {
            throw new BusinessException(BookingMessages.INVALID_BOOKING_STATUS_FOR_DELETION);
        }
    }

    public double calculateTotalPrice(Booking booking, List<RoomBooked> roomBookedList, RoomService roomService) {
        double totalPrice = 0;
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        long totalDaysBooked = Math.max(0, ChronoUnit.DAYS.between(startDate, endDate));

        for (RoomBooked roomBooked : roomBookedList) {
            Room room = roomService.getById(roomBooked.getRoom().getId());
            totalPrice += room.getCost() * totalDaysBooked;
        }

        return totalPrice;
    }
}
