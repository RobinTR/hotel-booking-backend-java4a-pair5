package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.BookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetByIdBookingResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@AllArgsConstructor
public class BookingsController {
    private BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddBookingRequest request) {
        return bookingService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateBookingRequest request) {
        return bookingService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return bookingService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllBookingResponse>> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdBookingResponse> getById(@PathVariable Integer getById) {
        return bookingService.getById(getById);
    }

    @GetMapping("/searchByDate")
    public DataResult<List<GetAllBookingResponse>> searchByDate(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return bookingService.searchByDate(startDate, endDate);
    }

    @GetMapping("/searchByRoomType")
    public DataResult<List<GetAllBookingResponse>> searchByRoomType(@RequestParam Integer roomTypeId) {
        return bookingService.searchByRoomType(roomTypeId);
    }

    @PatchMapping("/{id}/checkindate")
    public Result changeCheckInDate(@PathVariable Integer id) {
        return bookingService.changeCheckInDate(id);
    }

    @PatchMapping("/{id}/checkoutdate")
    public Result changeCheckOutDate(@PathVariable Integer id) {
        return bookingService.changeCheckOutDate(id);
    }

    @PatchMapping("/{id}/reservationstatus")
    public Result changeReservationStatus(@PathVariable Integer id, @RequestParam(value="reservationStatus")
    boolean reservationStatus) {
        return bookingService.changeReservationStatus(id, reservationStatus);
    }
}
