package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeedbackRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeedbackService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeedbackMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.RoomFeedbackRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFeedbackServiceImpl implements RoomFeedbackService {
    private final RoomFeedbackRepository roomFeedbackRepository;
    private final RoomFeedbackRules roomFeedbackRules;

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
        RoomFeedback roomFeedback = roomFeedbackRules.findById(id);
        roomFeedbackRepository.delete(roomFeedback);

        return RoomFeedbackMessages.ROOMFEEDBACK_DELETED;
    }

    @Override
    public List<RoomFeedback> getAll() {
        return roomFeedbackRepository.findAll();
    }

    @Override
    public RoomFeedback getById(Integer id) {
        return roomFeedbackRules.findById(id);
    }
}
