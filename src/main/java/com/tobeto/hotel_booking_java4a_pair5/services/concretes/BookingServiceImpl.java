package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.*;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.BookingRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomService roomService;
    private final RoomBookedService roomBookedService;
    private final CitizenService citizenService;
    private final CitizenOfBookingService citizenOfBookingService;
    private final BookingRules bookingRules;

    @Transactional
    @Override
    public Booking add(AddBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request);
        booking.setReservationStatus(ReservationStatus.PENDING);
        booking = bookingRepository.save(booking);

        List<CitizenOfBooking> citizenOfBookings = addCitizensToBooking(request.getCitizens(), booking.getId());
        booking.setCitizenOfBookings(citizenOfBookings);

        reserveRooms(request.getRoomIds(), booking.getId());

        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);
        booking.setTotalCost(bookingRules.calculateTotalPrice(booking, roomBookedList, roomService));
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
        Booking booking = bookingRules.findById(id);
        bookingRules.validateDeleteBooking(booking);

        List<RoomBooked> roomBookedList = roomBookedService.findByBooking(booking);
        for (RoomBooked roomBooked : roomBookedList) {
            roomBookedService.delete(roomBooked.getId());
        }

        bookingRepository.delete(booking);
        return BookingMessages.BOOKING_DELETED;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getById(Integer id) {
        return bookingRules.findById(id);
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
        Booking booking = bookingRules.findById(id);
        bookingRules.validateCheckInDateChange(booking);
        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public Booking changeCheckOutDate(Integer id) {
        Booking booking = bookingRules.findById(id);
        bookingRules.validateCheckOutDateChange(booking);
        bookingRepository.save(booking);

        return booking;
    }

    @Transactional
    @Override
    public Booking changeReservationStatus(Integer id, ReservationStatus reservationStatus) {
        Booking booking = bookingRules.findById(id);
        bookingRules.validateReservationStatusChange(booking, reservationStatus);
        bookingRepository.save(booking);

        return booking;
    }

    @Override
    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Booking> getBookingsByManagerId(Integer managerId) {
        return bookingRepository.findAllByManagerId(managerId);
    }

    private List<CitizenOfBooking> addCitizensToBooking(List<AddCitizenRequest> citizenRequests, Integer bookingId) {
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

    private void reserveRooms(List<Integer> roomIds, Integer bookingId) {
        for (Integer id : roomIds) {
            AddRoomBookedRequest roomBookedRequest = new AddRoomBookedRequest();
            roomBookedRequest.setBookingId(bookingId);
            roomBookedRequest.setRoomId(id);
            roomBookedService.add(roomBookedRequest);
        }
    }
}