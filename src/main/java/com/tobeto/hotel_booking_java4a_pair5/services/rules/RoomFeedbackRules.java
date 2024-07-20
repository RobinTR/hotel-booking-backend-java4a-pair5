package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeedbackRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeedbackMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomFeedbackRules {
    private final RoomFeedbackRepository roomFeedbackRepository;

    public RoomFeedback findById(Integer id) {
        return roomFeedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(RoomFeedbackMessages.ROOMFEEDBACK_NOT_FOUND));
    }
}
