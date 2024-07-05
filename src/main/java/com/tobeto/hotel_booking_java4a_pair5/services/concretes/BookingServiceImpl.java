package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.BookingBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomBookedService roomBookedService;
    private final BookingBusinessRules bookingBusinessRules;

    @Transactional
    @Override
    public Booking add(AddBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request);
        booking.setReservationStatus(ReservationStatus.PENDING);
        booking = bookingRepository.save(booking);

        for (Integer id : request.getRoomIds()) {
            AddRoomBookedRequest roomBookedRequest = new AddRoomBookedRequest();
            roomBookedRequest.setBookingId(booking.getId());
            roomBookedRequest.setRoomId(id);
            roomBookedService.add(roomBookedRequest);
        }

        booking.setTotalCost(bookingBusinessRules.reserveRoomAndCalculatePrice(booking.getId()));
        booking = bookingRepository.save(booking);

        return booking;
    }

    @Override
    public Booking update(UpdateBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromUpdateRequest(request);
        booking = bookingRepository.save(booking);

        return booking;
    }

    @Transactional
    @Override
    public String delete(Integer id) {
        Booking booking = bookingBusinessRules.getBooking(id);
        bookingBusinessRules.deleteBookingCheck(booking);
        bookingRepository.deleteById(booking.getId());

        return BookingMessages.BOOKING_DELETED;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Integer id) {
        Booking booking = bookingBusinessRules.getBooking(id);

        return booking;
    }

    @Override
    public List<Booking> searchByDate(LocalDate startDate, LocalDate endDate) {
        return bookingRepository.searchByDate(startDate, endDate);
    }

    @Override
    public List<Booking> searchByRoomType(Integer roomTypeId) {
        return bookingRepository.searchByRoomType(roomTypeId);
    }

    @Override
    public Booking changeCheckInDate(Integer id) {
        Booking booking = bookingBusinessRules.getBooking(id);
        bookingBusinessRules.changeCheckInDate(booking);
        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public Booking changeCheckOutDate(Integer id) {
        Booking booking = bookingBusinessRules.getBooking(id);
        bookingBusinessRules.changeCheckOutDate(booking);
        bookingRepository.save(booking);

        return booking;
    }

    @Transactional
    @Override
    public Booking changeReservationStatus(Integer id, ReservationStatus reservationStatus) {
        Booking booking = bookingBusinessRules.getBooking(id);
        bookingBusinessRules.changeReservationStatus(booking, reservationStatus);
        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findAllByUserId(userId);
    }
}
