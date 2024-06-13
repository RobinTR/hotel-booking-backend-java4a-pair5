package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
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
    public Response add(@RequestBody @Valid AddGuestRequest request) {
        return guestService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateGuestRequest request) {
        return guestService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return guestService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllGuestResponse>> getAll() {
        return guestService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdGuestResponse> getById(@PathVariable Integer getById) {
        return guestService.getById(getById);
    }
}
