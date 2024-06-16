package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;

import java.util.List;

public interface RoomFeedbackService {
    RoomFeedback add(AddRoomFeedbackRequest request);

    RoomFeedback update(UpdateRoomFeedbackRequest request);

    String delete(Integer id);

    List<RoomFeedback> getAll();

    RoomFeedback getById(Integer id);
}
