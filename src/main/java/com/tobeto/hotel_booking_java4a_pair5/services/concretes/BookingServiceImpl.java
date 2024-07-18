package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.Citizen;
import com.tobeto.hotel_booking_java4a_pair5.entities.CitizenOfBooking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenOfBookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.BookingBusinessRules;
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
    private final RoomBookedService roomBookedService;
    private final BookingBusinessRules bookingBusinessRules;
    private final CitizenService citizenService;
    private final CitizenOfBookingService citizenOfBookingService;

    @Transactional
    @Override
    public Booking add(AddBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request);
        booking.setReservationStatus(ReservationStatus.PENDING);
        booking = bookingRepository.save(booking);

        //Manuel mapping for citizen details
        List<CitizenOfBooking> citizenOfBookings = new ArrayList<>();

        for (AddCitizenRequest citizenRequest : request.getCitizens()) {
            Citizen citizen = citizenService.add(citizenRequest);
            AddCitizenOfBookingRequest addCitizenOfBookingRequest = CitizenOfBookingMapper.INSTANCE.addCitizenOfBookingRequestFromCitizen(citizen);
            addCitizenOfBookingRequest.setBookingId(booking.getId());
            CitizenOfBooking citizenOfBooking = citizenOfBookingService.add(addCitizenOfBookingRequest);
            citizenOfBookings.add(citizenOfBooking);
        }

        booking.setCitizenOfBookings(citizenOfBookings);

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

    @Override
    public List<Booking> getBookingsByManagerId(Integer managerId) {
        return bookingRepository.findAllByManagerId(managerId);
    }
}
