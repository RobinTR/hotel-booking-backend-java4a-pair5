package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.*;

import java.util.List;

public interface RoomFeedbackService {
    Result add(AddRoomFeedbackRequest request);
    Result update(UpdateRoomFeedbackRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllRoomFeedbackResponse>> getAll();
    DataResult<GetByIdRoomFeedbackResponse> getById(Integer id);
}
