package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetAllRoomTypeResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomTypeMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypes")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RoomTypesController {
    private RoomTypeService roomTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomTypeRequest request) {
        roomTypeService.add(request);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_ADDED);

    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomTypeRequest request) {
        roomTypeService.update(request);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_UPDATED);

    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        roomTypeService.delete(id);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_DELETED);

    }

    @GetMapping
    public DataResponse<List<GetAllRoomTypeResponse>> getAll() {
        List<RoomType> roomTypes = roomTypeService.getAll();
        List<GetAllRoomTypeResponse> getAllRoomTypeResponseList = RoomTypeMapper.INSTANCE.getAllRoomTypeResponseListFromRoomTypes(roomTypes);

        return new SuccessDataResponse<>(getAllRoomTypeResponseList, RoomTypeMessages.ROOMTYPE_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomTypeResponse> getById(@PathVariable Integer getById) {
        RoomType roomType = roomTypeService.getById(getById);
        GetByIdRoomTypeResponse getByIdRoomTypeResponse = RoomTypeMapper.INSTANCE.getByIdRoomTypeResponseFromRoomType(roomType);

        return new SuccessDataResponse<>(getByIdRoomTypeResponse, RoomTypeMessages.ROOMTYPE_LISTED);

    }
}
