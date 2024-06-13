package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Room add(AddRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromAddRequest(request);
        room = roomRepository.save(room);

        return room;
    }

    @Override
    public Room update(UpdateRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromUpdateRequest(request);
        room = roomRepository.save(room);

        return room;
    }

    @Override
    public String delete(Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomMessages.ROOM_NOT_FOUND));
        roomRepository.delete(room);

        return RoomMessages.ROOM_DELETED;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomMessages.ROOM_NOT_FOUND));

        return room;
    }
}
