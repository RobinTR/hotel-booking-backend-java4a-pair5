package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomBusinessRules {
    private final RoomRepository roomRepository;

    public Room getRoom(Integer roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new BusinessException(RoomMessages.ROOM_NOT_FOUND));

        return room;
    }

    public boolean isRoomAvailable(Integer roomId) {
        Room room = getRoom(roomId);

        if (!room.isAvailable()) {
            throw new BusinessException(RoomMessages.ROOM_IS_NOT_AVAILABLE);
        }

        return true;
    }
}
