package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.AddRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.UpdateRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetAllRoomFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeatureMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomfeatures")
@AllArgsConstructor
public class RoomFeaturesController {
    private RoomFeatureService roomFeatureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomFeatureRequest request) {
        roomFeatureService.add(request);

        return new SuccessResponse(RoomFeatureMessages.ROOM_FEATURE_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomFeatureRequest request) {
        roomFeatureService.update(request);

        return new SuccessResponse(RoomFeatureMessages.ROOM_FEATURE_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        String message = roomFeatureService.delete(id);

        return new SuccessResponse(message);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomFeatureResponse>> getAll(@RequestParam Integer roomId) {
        List<RoomFeature> roomFeatures = roomFeatureService.getAllFeaturesByRoomId(roomId);
        List<GetAllRoomFeatureResponse> getAllRoomFeatureResponseList = RoomFeatureMapper.INSTANCE.getAllResponseFromRoomFeatureList(roomFeatures);

        return new SuccessDataResponse<>(getAllRoomFeatureResponseList, RoomFeatureMessages.ROOM_FEATURE_LISTED);
    }
}
