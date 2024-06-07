package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
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
    public Result add(@RequestBody @Valid AddGuestRequest request) {
        return guestService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateGuestRequest request) {
        return guestService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return guestService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllGuestResponse>> getAll() {
        return guestService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdGuestResponse> getById(@PathVariable Integer getById) {
        return guestService.getById(getById);
    }
}
