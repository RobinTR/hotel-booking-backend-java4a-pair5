package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetAllRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoomsController {
    private RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomRequest request) {
        roomService.add(request);

        return new SuccessResponse(RoomMessages.ROOM_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomRequest request) {
        roomService.update(request);

        return new SuccessResponse(RoomMessages.ROOM_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        roomService.delete(id);

        return new SuccessResponse(RoomMessages.ROOM_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomResponse>> getAll() {
        List<Room> rooms = roomService.getAll();
        List<GetAllRoomResponse> getAllRoomResponseList = RoomMapper.INSTANCE.getAllRoomResponseListFromRooms(rooms);

        return new SuccessDataResponse<>(getAllRoomResponseList, RoomMessages.ROOM_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomResponse> getById(@PathVariable Integer getById) {
        Room room = roomService.getById(getById);
        GetByIdRoomResponse getByIdRoomResponse = RoomMapper.INSTANCE.getByIdRoomResponseFromRoom(room);

        return new SuccessDataResponse<>(getByIdRoomResponse, RoomMessages.ROOM_LISTED);
    }

    /*@GetMapping("/roomType")
    public DataResult<List<GetAllRoomResponse>> searchByRoomType(@RequestParam String name) {
        return roomService.searchByRoomType(name);
    }*/
}
