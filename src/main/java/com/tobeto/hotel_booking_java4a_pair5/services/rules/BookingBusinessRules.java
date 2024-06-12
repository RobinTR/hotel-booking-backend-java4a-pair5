package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingBusinessRules {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final RoomBookedService roomBookedService;

    public double calculatePrice(Integer id) {
        double totalPrice = 0;
        Long totalDaysBooked;
        LocalDate startDate;
        LocalDate endDate;
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BusinessException(BookingMessages.BOOKING_NOT_FOUND));
        DataResult<List<GetByIdRoomBookedResponse>> getByIdRoomBookedResponseList = roomBookedService.findByBookingId(id);
        List<GetByIdRoomBookedResponse> roomBookedResponses = getByIdRoomBookedResponseList.getData();
        startDate = booking.getStartDate();
        endDate = booking.getEndDate();
        totalDaysBooked = Math.max(0, ChronoUnit.DAYS.between(startDate, endDate));

        for (GetByIdRoomBookedResponse response : roomBookedResponses) {
            RoomBooked roomBooked = RoomBookedMapper.INSTANCE.getRoomBookedFromGetByIdRoomBookedResponse(response);
            DataResult<GetByIdRoomResponse> getByIdRoomResponseDataResult = roomService.getById(roomBooked.getRoom().getId());
            totalPrice += getByIdRoomResponseDataResult.getData().getCost() * totalDaysBooked;
        }

        return totalPrice;
    }

    public Booking isBookingExist(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BusinessException(BookingMessages.BOOKING_NOT_FOUND));

        return booking;
    }

    public void changeReservationStatus(Booking booking, boolean isConfirmed) {
        if (isConfirmed) {
            booking.setReservationStatus(ReservationStatus.APPROVED);
        } else {
            booking.setReservationStatus(ReservationStatus.ABORTED);
        }
    }

    public void changeCheckInDate(Booking booking) {
        booking.setCheckInDate(LocalDateTime.now());
    }

    public void changeCheckOutDate(Booking booking) {
        booking.setCheckOutDate(LocalDateTime.now());
    }
}
