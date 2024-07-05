package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetBookingByUserIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetByIdBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.citizenofbooking.GetCitizenOfBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.RoomBookedDtoForBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookingsController {
    private BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddBookingRequest request) {
        bookingService.add(request);

        return new SuccessResponse(BookingMessages.BOOKING_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateBookingRequest request) {
        bookingService.update(request);

        return new SuccessResponse(BookingMessages.BOOKING_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        bookingService.delete(id);

        return new SuccessResponse(BookingMessages.BOOKING_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllBookingResponse>> getAll() {
        List<Booking> bookings = bookingService.getAll();
        List<GetAllBookingResponse> bookingResponseList = BookingMapper.INSTANCE.getAllBookingResponseListFromBookings(bookings);

        return new SuccessDataResponse<>(bookingResponseList, BookingMessages.BOOKING_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdBookingResponse> getById(@PathVariable Integer getById) {
        Booking booking = bookingService.getById(getById);
        GetByIdBookingResponse getByIdBookingResponse = BookingMapper.INSTANCE.getByIdBookingResponse(booking);

        return new SuccessDataResponse<>(getByIdBookingResponse, BookingMessages.BOOKING_LISTED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/searchByDate")
    public DataResponse<List<GetAllBookingResponse>> searchByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<Booking> bookings = bookingService.searchByDate(startDate, endDate);
        List<GetAllBookingResponse> getAllBookingResponseList = BookingMapper.INSTANCE.getAllBookingResponseListFromBookings(bookings);

        return new SuccessDataResponse<>(getAllBookingResponseList, BookingMessages.BOOKING_LISTED);
    }

    @GetMapping("/searchByRoomType")
    public DataResponse<List<GetAllBookingResponse>> searchByRoomType(@RequestParam Integer roomTypeId) {
        List<Booking> bookings = bookingService.searchByRoomType(roomTypeId);
        List<GetAllBookingResponse> getAllBookingResponseList = BookingMapper.INSTANCE.getAllBookingResponseListFromBookings(bookings);

        return new SuccessDataResponse<>(getAllBookingResponseList, BookingMessages.BOOKING_LISTED);
    }

    @PatchMapping("/{id}/checkindate")
    public Response changeCheckInDate(@PathVariable Integer id) {
        bookingService.changeCheckInDate(id);

        return new SuccessResponse(BookingMessages.BOOKING_CHECK_IN_DATE_UPDATED);
    }

    @PatchMapping("/{id}/checkoutdate")
    public Response changeCheckOutDate(@PathVariable Integer id) {
        bookingService.changeCheckOutDate(id);

        return new SuccessResponse(BookingMessages.BOOKING_CHECK_OUT_DATE_UPDATED);
    }

    @PatchMapping("/{id}/reservationstatus")
    public Response changeReservationStatus(@PathVariable Integer id, @RequestParam ReservationStatus reservationStatus) {
        bookingService.changeReservationStatus(id, reservationStatus);

        return new SuccessResponse(BookingMessages.BOOKING_RESERVATION_STATUS_UPDATED);
    }

    @GetMapping("/getBookingsByUserId")
    public DataResponse<List<GetBookingByUserIdResponse>> getBookingsByUserId(@RequestParam Integer userId) {
        List<GetBookingByUserIdResponse> response = new ArrayList<>();
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);

        for (Booking booking : bookings) {
            GetBookingByUserIdResponse getBookingByUserIdResponse = BookingMapper.INSTANCE.getBookingByUserIdResponseMap(booking);
            List<RoomBookedDtoForBookingResponse> roomBookedDtoForBookingResponseList = RoomBookedMapper.INSTANCE.getRoomBookedDtoForBookingResponseListFromRoomBookedList(booking.getRoomBooked());
            List<GetCitizenOfBookingResponse> citizenOfBookingResponseList = CitizenOfBookingMapper.INSTANCE.getCitizenOfBookingListFromCitizenOfBookingList(booking.getCitizenOfBookings());

            getBookingByUserIdResponse.setRoomBooked(roomBookedDtoForBookingResponseList);
            getBookingByUserIdResponse.setCitizenOfBookings(citizenOfBookingResponseList);

            response.add(getBookingByUserIdResponse);
        }

        return new SuccessDataResponse<>(response, BookingMessages.BOOKING_LISTED);
    }
}
