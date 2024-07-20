package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenOfBookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingRules {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final RoomBookedService roomBookedService;
    private final CitizenService citizenService;
    private final CitizenOfBookingService citizenOfBookingService;

    public double reserveRoomAndCalculatePrice(Integer id) {
        double totalPrice = 0;

        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BusinessException(BookingMessages.BOOKING_NOT_FOUND));
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        long totalDaysBooked = Math.max(0, ChronoUnit.DAYS.between(startDate, endDate));

        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);

        for (RoomBooked roomBooked : roomBookedList) {
            Room room = roomService.getById(roomBooked.getRoom().getId());
            UpdateRoomRequest updateRoomRequest = RoomMapper.INSTANCE.updateRoomRequestFromRoom(room);
            roomService.update(updateRoomRequest);

            totalPrice += room.getCost() * totalDaysBooked;
        }

        return totalPrice;
    }

    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(BookingMessages.BOOKING_NOT_FOUND));
    }

    public void changeReservationStatus(Booking booking, ReservationStatus reservationStatus) {
        if (reservationStatus.equals(ReservationStatus.APPROVED)) {
            booking.setReservationStatus(ReservationStatus.APPROVED);
        } else if (reservationStatus.equals(ReservationStatus.ABORTED)) {
            booking.setReservationStatus(ReservationStatus.ABORTED);
        } else if (reservationStatus.equals(ReservationStatus.COMPLETED)) {
            booking.setReservationStatus(ReservationStatus.COMPLETED);
        }
    }

    public void changeCheckInDate(Booking booking) {
        booking.setCheckInDate(LocalDateTime.now());
    }

    public void changeCheckOutDate(Booking booking) {
        booking.setCheckOutDate(LocalDateTime.now());
        booking.setReservationStatus(ReservationStatus.COMPLETED);
        bookingRepository.save(booking);
    }

    public void deleteBookingCheck(Booking booking) {
        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);

        if (booking.getReservationStatus() == ReservationStatus.APPROVED) {
            for (RoomBooked roomBooked : roomBookedList) {
                roomBookedService.delete(roomBooked.getId());
            }

            bookingRepository.delete(booking);
        }
    }

    public List<CitizenOfBooking> addCitizensToBooking(List<AddCitizenRequest> citizenRequests, Integer bookingId) {
        List<CitizenOfBooking> citizenOfBookings = new ArrayList<>();

        for (AddCitizenRequest citizenRequest : citizenRequests) {
            Citizen citizen = citizenService.add(citizenRequest);
            AddCitizenOfBookingRequest addCitizenOfBookingRequest = CitizenOfBookingMapper.INSTANCE.addCitizenOfBookingRequestFromCitizen(citizen);
            addCitizenOfBookingRequest.setBookingId(bookingId);
            CitizenOfBooking citizenOfBooking = citizenOfBookingService.add(addCitizenOfBookingRequest);
            citizenOfBookings.add(citizenOfBooking);
        }

        return citizenOfBookings;
    }

    public void reserveRooms(List<Integer> roomIds, Integer bookingId) {
        for (Integer id : roomIds) {
            AddRoomBookedRequest roomBookedRequest = new AddRoomBookedRequest();
            roomBookedRequest.setBookingId(bookingId);
            roomBookedRequest.setRoomId(id);
            roomBookedService.add(roomBookedRequest);
        }
    }
}
