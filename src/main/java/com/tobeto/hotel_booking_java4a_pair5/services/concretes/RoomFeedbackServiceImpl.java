package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.*;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeedbackRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.*;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomFeedbackServiceImpl implements RoomFeedbackService {
    private final RoomFeedbackRepository roomFeedbackRepository;

    @Override
    public Result add(AddRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromAddRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return new SuccessResult(RoomFeedbackMessages.ROOMFEEDBACK_ADDED);
    }

    @Override
    public Result update(UpdateRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromUpdateRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return new SuccessResult(RoomFeedbackMessages.ROOMFEEDBACK_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllRoomFeedbackResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdRoomFeedbackResponse> getById(Integer id) {
        return null;
    }
}
