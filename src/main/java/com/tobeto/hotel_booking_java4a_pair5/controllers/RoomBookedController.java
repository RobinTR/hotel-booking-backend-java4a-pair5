package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetAllRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roombooked")
@AllArgsConstructor
public class RoomBookedController {
    private RoomBookedService roomBookedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddRoomBookedRequest request) {
        return roomBookedService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateRoomBookedRequest request) {
        return roomBookedService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return roomBookedService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllRoomBookedResponse>> getAll() {
        return roomBookedService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdRoomBookedResponse> getById(@PathVariable Integer getById) {
        return roomBookedService.getById(getById);
    }
}
