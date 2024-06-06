package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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
        return null;
    }

    @Override
    public DataResult<List<GetAllBookingResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdBookingResponse> getById(Integer id) {
        return null;
    }
}
