package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetAllRoomFeedbackResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetByIdRoomFeedbackResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeedbackMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomfeedbacks")
@AllArgsConstructor
public class RoomFeedbacksController {
    private RoomFeedbackService roomFeedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddRoomFeedbackRequest request) {
        roomFeedbackService.add(request);
        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomFeedbackRequest request) {
        roomFeedbackService.update(request);
        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        roomFeedbackService.delete(id);
        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_DELETED);

    }

    @GetMapping
    public DataResponse<List<GetAllRoomFeedbackResponse>> getAll() {
        List<RoomFeedback> roomFeedbacks = roomFeedbackService.getAll();
        List<GetAllRoomFeedbackResponse> getAllRoomFeedbackResponseList = RoomFeedbackMapper.INSTANCE.getAllRoomFeedbackResponseListFromRoomFeedbacks(roomFeedbacks);

        return new SuccessDataResponse<>(getAllRoomFeedbackResponseList, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomFeedbackResponse> getById(@PathVariable Integer getById) {
        RoomFeedback roomFeedback = roomFeedbackService.getById(getById);
        GetByIdRoomFeedbackResponse getByIdRoomFeedbackResponse = RoomFeedbackMapper.INSTANCE.getByIdRoomFeedbackResponseFromRoomFeedback(roomFeedback);

        return new SuccessDataResponse<>(getByIdRoomFeedbackResponse, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);
    }
}
