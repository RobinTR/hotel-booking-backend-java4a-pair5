package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetAllRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
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
    public Response add(@RequestBody @Valid AddRoomBookedRequest request) {
        roomBookedService.add(request);

        return new SuccessResponse(RoomBookedMessages.ROOMBOOKED_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomBookedRequest request) {
        roomBookedService.update(request);

        return new SuccessResponse(RoomBookedMessages.ROOMBOOKED_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        roomBookedService.delete(id);

        return new SuccessResponse(RoomBookedMessages.ROOMBOOKED_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomBookedResponse>> getAll() {
        List<RoomBooked> roomBooked = roomBookedService.getAll();
        List<GetAllRoomBookedResponse> response = RoomBookedMapper.INSTANCE.getAllRoomBookedResponseListFromRoomBooked(roomBooked);

        return new SuccessDataResponse<>(response, RoomBookedMessages.ROOMBOOKED_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomBookedResponse> getById(@PathVariable Integer getById) {
        RoomBooked roomBooked = roomBookedService.getById(getById);
        GetByIdRoomBookedResponse response = RoomBookedMapper.INSTANCE.getByIdRoomBookedResponseFromRoomBooked(roomBooked);

        return new SuccessDataResponse<>(response, RoomBookedMessages.ROOMBOOKED_LISTED);
    }
}
