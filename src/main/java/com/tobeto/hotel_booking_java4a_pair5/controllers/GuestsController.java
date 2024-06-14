package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
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
}
