package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.repositories.BookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetByIdBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Override
    public Result add(AddBookingRequest request) {
        Booking booking = BookingMapper.INSTANCE.bookingFromAddRequest(request);
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
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(BookingMessages.BOOKING_NOT_FOUND));
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
        Booking bookings = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException(BookingMessages.BOOKING_NOT_FOUND));
        GetByIdBookingResponse response = BookingMapper.INSTANCE.getByIdBookingResponse(bookings);

        return new SuccessDataResult<>(response, BookingMessages.BOOKING_LISTED);
    }
}
