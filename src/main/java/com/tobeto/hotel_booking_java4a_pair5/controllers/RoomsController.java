package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetAllRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
public class RoomsController {
    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddRoomRequest request) {
        return roomService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateRoomRequest request) {
        return roomService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return roomService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllRoomResponse>> getAll() {
        return roomService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdRoomResponse> getById(@PathVariable Integer getById) {
        return roomService.getById(getById);
    }
}
