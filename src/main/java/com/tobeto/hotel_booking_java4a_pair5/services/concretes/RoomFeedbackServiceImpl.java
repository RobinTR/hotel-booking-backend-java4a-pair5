package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromAddRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_ADDED);
    }

    @Override
    public Response update(UpdateRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromUpdateRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
        roomFeedbackRepository.delete(roomFeedback);

        return new SuccessResponse(RoomFeedbackMessages.ROOMFEEDBACK_DELETED);
    }

    @Override
    public DataResponse<List<GetAllRoomFeedbackResponse>> getAll() {
        List<RoomFeedback> roomFeedbacks = roomFeedbackRepository.findAll();
        List<GetAllRoomFeedbackResponse> response = RoomFeedbackMapper.INSTANCE.getAllRoomFeedbackResponseListFromRoomFeedbacks(roomFeedbacks);

        return new SuccessDataResponse<>(response, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);
    }

    @Override
    public DataResponse<GetByIdRoomFeedbackResponse> getById(Integer id) {
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
        GetByIdRoomFeedbackResponse response = RoomFeedbackMapper.INSTANCE.getByIdRoomFeedbackResponseFromRoomFeedback(roomFeedback);

        return new SuccessDataResponse<>(response, RoomFeedbackMessages.ROOMFEEDBACK_LISTED);
    }
}
