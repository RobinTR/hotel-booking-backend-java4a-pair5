package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roomfeedbacks")
@AllArgsConstructor
public class RoomFeedbacksController {
    private RoomFeedbackService roomFeedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddRoomFeedbackRequest request) {
        return roomFeedbackService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateRoomFeedbackRequest request) {
        return roomFeedbackService.update(request);
    }
}
