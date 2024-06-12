package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetByIdBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.BookingBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomBookedService roomBookedService;
    private final RoomService roomService;
    private final BookingBusinessRules bookingBusinessRules;

    @Override
    public Result add(AddBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request);
        booking.setReservationStatus(ReservationStatus.PENDING);
        booking = bookingRepository.save(booking);

        for (Integer id : request.getRoomIds()) {
            RoomBooked roomBooked = new RoomBooked();
            roomBooked.setBooking(booking);
            GetByIdRoomResponse getByIdRoomResponse = roomService.getById(id).getData();
            Room room = RoomMapper.INSTANCE.roomFromGetByIdResponse(getByIdRoomResponse);
            roomBooked.setRoom(room);
            roomBookedService.add(RoomBookedMapper.INSTANCE.roomBookedFromAddRequest(roomBooked));
        }

        booking.setTotalCost(bookingBusinessRules.calculatePrice(booking.getId()));
        booking = bookingRepository.save(booking);

        return new SuccessResult(BookingMessages.BOOKING_ADDED);
    }

    @Override
    public Result update(UpdateBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromUpdateRequest(request);
        booking = bookingRepository.save(booking);

        return new SuccessResult(BookingMessages.BOOKING_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        //TODO: Refactor Exception and Message
        Booking booking = bookingBusinessRules.isBookingExist(id);
        bookingRepository.deleteById(booking.getId());

        return new SuccessResult(BookingMessages.BOOKING_DELETED);
    }

    @Override
    public DataResult<List<GetAllBookingResponse>> getAll() {
        List<Booking> bookings = bookingRepository.findAll();
        List<GetAllBookingResponse> response = BookingMapper.INSTANCE.getAllBookingResponseList(bookings);

        return new SuccessDataResult<>(response, BookingMessages.BOOKING_LISTED);
    }

    @Override
    public DataResult<GetByIdBookingResponse> getById(Integer id) {
        Booking booking = bookingBusinessRules.isBookingExist(id);
        GetByIdBookingResponse response = BookingMapper.INSTANCE.getByIdBookingResponse(booking);

        return new SuccessDataResult<>(response, BookingMessages.BOOKING_LISTED);
    }

    @Override
    public DataResult<List<GetAllBookingResponse>> searchByDate(LocalDate startDate, LocalDate endDate) {
        return new SuccessDataResult<>(bookingRepository.searchByDate(startDate, endDate), BookingMessages.BOOKING_LISTED);
    }

    @Override
    public DataResult<List<GetAllBookingResponse>> searchByRoomType(Integer roomTypeId) {
        return new SuccessDataResult<>(bookingRepository.searchByRoomType(roomTypeId));
    }

    @Override
    public Result changeCheckInDate(Integer id) {
        Booking booking = bookingBusinessRules.isBookingExist(id);
        bookingBusinessRules.changeCheckInDate(booking);
        bookingRepository.save(booking);

        return new SuccessResult(BookingMessages.BOOKING_CHECK_IN_DATE_UPDATED);
    }

    @Override
    public Result changeCheckOutDate(Integer id) {
        Booking booking = bookingBusinessRules.isBookingExist(id);
        bookingBusinessRules.changeCheckOutDate(booking);
        bookingRepository.save(booking);

        return new SuccessResult(BookingMessages.BOOKING_CHECK_OUT_DATE_UPDATED);
    }

    @Override
    public Result changeReservationStatus(Integer id, boolean isConfirmed) {
        Booking booking = bookingBusinessRules.isBookingExist(id);
        bookingBusinessRules.changeReservationStatus(booking, isConfirmed);
        bookingRepository.save(booking);

        return new SuccessResult(BookingMessages.BOOKING_RESERVATION_STATUS_UPDATED);
    }
}
