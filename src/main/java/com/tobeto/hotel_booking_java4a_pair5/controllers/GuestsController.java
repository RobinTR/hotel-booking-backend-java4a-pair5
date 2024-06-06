package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
@AllArgsConstructor
public class GuestsController {
    private GuestService guestService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddGuestRequest request) {
        return guestService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateGuestRequest request) {
        return guestService.update(request);
    }
}
