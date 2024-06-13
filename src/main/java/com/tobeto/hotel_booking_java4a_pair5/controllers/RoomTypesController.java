package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetAllRoomTypeResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypes")
@AllArgsConstructor
public class RoomTypesController {
    private RoomTypeService roomTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomTypeRequest request) {
        return roomTypeService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomTypeRequest request) {
        return roomTypeService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return roomTypeService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomTypeResponse>> getAll() {
        return roomTypeService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomTypeResponse> getById(@PathVariable Integer getById) {
        return roomTypeService.getById(getById);
    }
}
