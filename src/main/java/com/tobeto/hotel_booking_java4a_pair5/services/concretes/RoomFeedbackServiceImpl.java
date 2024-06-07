package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeedbackRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetAllRoomFeedbackResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetByIdRoomFeedbackResponse;
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
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
        roomFeedbackRepository.delete(roomFeedback);

        return new SuccessResult(RoomFeedbackMessages.ROOMFEEDBACK_DELETED);
    }

    @Override
    public DataResult<List<GetAllRoomFeedbackResponse>> getAll() {
        List<RoomFeedback> roomFeedbacks = roomFeedbackRepository.findAll();
        List<GetAllRoomFeedbackResponse> response = RoomFeedbackMapper.INSTANCE.getAllRoomFeedbackResponseListFromRoomFeedbacks(roomFeedbacks);

        return new SuccessDataResult<>(response, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);
    }

    @Override
    public DataResult<GetByIdRoomFeedbackResponse> getById(Integer id) {
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
        GetByIdRoomFeedbackResponse response = RoomFeedbackMapper.INSTANCE.getByIdRoomFeedbackResponseFromRoomFeedback(roomFeedback);

        return new SuccessDataResult<>(response, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);
    }
}
