package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeedbackRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomFeedbackServiceImpl implements RoomFeedbackService {
    private final RoomFeedbackRepository roomFeedbackRepository;

    @Override
    public RoomFeedback add(AddRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromAddRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return roomFeedback;
    }

    @Override
    public RoomFeedback update(UpdateRoomFeedbackRequest request) {
        RoomFeedback roomFeedback = RoomFeedbackMapper.INSTANCE.roomFeedbackFromUpdateRequest(request);
        roomFeedback = roomFeedbackRepository.save(roomFeedback);

        return roomFeedback;
    }

    @Override
    public String delete(Integer id) {
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new BusinessException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
        roomFeedbackRepository.delete(roomFeedback);

        return RoomFeedbackMessages.ROOMFEEDBACK_DELETED;
    }

    @Override
    public List<RoomFeedback> getAll() {
        return roomFeedbackRepository.findAll();

    }

    @Override
    public RoomFeedback getById(Integer id) {
        RoomFeedback roomFeedback = roomFeedbackRepository.findById(id).orElseThrow(() -> new BusinessException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));

        return roomFeedback;
    }
}
