package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.BookingMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetBookingByUserIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.citizenofbooking.GetCitizenOfBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.RoomBookedDtoForBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.BookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GuestsController {
    private GuestService guestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddGuestRequest request) {
        return new SuccessResponse(GuestMessages.GUEST_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateGuestRequest request) {
        return new SuccessResponse(GuestMessages.GUEST_UPDATED);

    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        guestService.delete(id);
        return new SuccessResponse(GuestMessages.GUEST_DELETED);

    }

    @GetMapping
    public DataResponse<List<GetAllGuestResponse>> getAll() {
        List<Guest> guests = guestService.getAll();
        List<GetAllGuestResponse> guestResponseList = GuestMapper.INSTANCE.getAllGuestResponseList(guests);

        return new SuccessDataResponse<>(guestResponseList, GuestMessages.GUEST_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdGuestResponse> getById(@PathVariable Integer getById) {
        Guest guest = guestService.getById(getById);
        GetByIdGuestResponse getByIdGuestResponse = GuestMapper.INSTANCE.getByIdGuestResponse(guest);

        return new SuccessDataResponse<>(getByIdGuestResponse, GuestMessages.GUEST_LISTED);
    }

    @GetMapping("/getGuestIdByUserId")
    public DataResponse<Integer> getGuestIdByUserId(@RequestParam Integer userId) {
        Integer guestId = guestService.getByUserId(userId);

        return new SuccessDataResponse<>(guestId, GuestMessages.GUEST_LISTED);
    }
}
