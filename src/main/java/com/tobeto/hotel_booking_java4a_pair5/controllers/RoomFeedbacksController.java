package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetAllRoomFeedbackResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetByIdRoomFeedbackResponse;
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
        return roomFeedbackService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateRoomFeedbackRequest request) {
        return roomFeedbackService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return roomFeedbackService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllRoomFeedbackResponse>> getAll() {
        return roomFeedbackService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdRoomFeedbackResponse> getById(@PathVariable Integer getById) {
        return roomFeedbackService.getById(getById);
    }
}
