package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingBusinessRules {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final RoomBookedService roomBookedService;
    private final RoomBusinessRules roomBusinessRules;

    public double reserveRoomAndCalculatePrice(Integer id) {
        double totalPrice = 0;

        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BusinessException(BookingMessages.BOOKING_NOT_FOUND));
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        long totalDaysBooked = Math.max(0, ChronoUnit.DAYS.between(startDate, endDate));

        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);

        for (RoomBooked roomBooked : roomBookedList) {
            Room room = roomService.getById(roomBooked.getRoom().getId());
            roomBusinessRules.isRoomAvailable(room.getId());
            UpdateRoomRequest updateRoomRequest = RoomMapper.INSTANCE.updateRoomRequestFromRoom(room);
            updateRoomRequest.setAvailable(false);
            roomService.update(updateRoomRequest);

            totalPrice += room.getCost() * totalDaysBooked;
        }

        return totalPrice;
    }

    public Booking getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BusinessException(BookingMessages.BOOKING_NOT_FOUND));

        return booking;
    }

    public void changeReservationStatus(Booking booking, ReservationStatus reservationStatus) {
        if (reservationStatus.equals(ReservationStatus.APPROVED)) {
            List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);
            setRoomAvailable(roomBookedList, false);

            booking.setReservationStatus(ReservationStatus.APPROVED);

        } else if (reservationStatus.equals(ReservationStatus.ABORTED)) {
            List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);
            setRoomAvailable(roomBookedList, true);

            booking.setReservationStatus(ReservationStatus.ABORTED);
        } else if (reservationStatus.equals(ReservationStatus.COMPLETED)) {
            List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);
            setRoomAvailable(roomBookedList, true);

            booking.setReservationStatus(ReservationStatus.COMPLETED);
        }
    }

    public void changeCheckInDate(Booking booking) {
        booking.setCheckInDate(LocalDateTime.now());
    }

    public void changeCheckOutDate(Booking booking) {
        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);

        booking.setCheckOutDate(LocalDateTime.now());
        booking.setReservationStatus(ReservationStatus.COMPLETED);
        setRoomAvailable(roomBookedList, true);
        bookingRepository.save(booking);
    }

    public void deleteBookingCheck(Booking booking) {
        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);

        if (booking.getReservationStatus() == ReservationStatus.APPROVED) {
            for (RoomBooked roomBooked : roomBookedList) {
                roomBookedService.delete(roomBooked.getId());
            }

            setRoomAvailable(roomBookedList, true);
            bookingRepository.delete(booking);
        }
    }

    public void setRoomAvailable(List<RoomBooked> roomBookedList, boolean available) {
        for (RoomBooked roomBooked : roomBookedList) {
            Room room = roomService.getById(roomBooked.getRoom().getId());
            UpdateRoomRequest updateRoomRequest = RoomMapper.INSTANCE.updateRoomRequestFromRoom(room);
            updateRoomRequest.setAvailable(available);
            roomService.update(updateRoomRequest);
        }
    }
}
