package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomTypeFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.AddRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.UpdateRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomTypeFeatureMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtypefeatures")
@AllArgsConstructor
public class RoomTypeFeaturesController {
    private RoomTypeFeatureService roomTypeFeatureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomTypeFeatureRequest request) {
        roomTypeFeatureService.add(request);

        return new SuccessResponse(RoomTypeFeatureMessages.ROOM_TYPE_FEATURE_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomTypeFeatureRequest request) {
        roomTypeFeatureService.update(request);

        return new SuccessResponse(RoomTypeFeatureMessages.ROOM_TYPE_FEATURE_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        String message = roomTypeFeatureService.delete(id);

        return new SuccessResponse(message);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomTypeFeatureResponse>> getAll(@RequestParam Integer roomTypeId) {
        List<RoomTypeFeature> roomTypeFeatures = roomTypeFeatureService.getAllFeaturesByRoomTypeId(roomTypeId);
        List<GetAllRoomTypeFeatureResponse> getAllRoomTypeFeatureResponseList = RoomTypeFeatureMapper.INSTANCE.getAllResponseFromRoomTypeFeatureList(roomTypeFeatures);

        return new SuccessDataResponse<>(getAllRoomTypeFeatureResponseList, RoomTypeFeatureMessages.ROOM_TYPE_FEATURE_LISTED);
    }
}
