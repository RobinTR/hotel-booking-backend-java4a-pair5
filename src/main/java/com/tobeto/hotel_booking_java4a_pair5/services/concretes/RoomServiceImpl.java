package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.*;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.*;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public Result add(AddRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromAddRequest(request);
        room = roomRepository.save(room);

        return new SuccessResult(RoomMessages.ROOMSERVICE_ADDED);
    }

    @Override
    public Result update(UpdateRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromUpdateRequest(request);
        room = roomRepository.save(room);

        return new SuccessResult(RoomMessages.ROOMSERVICE_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllRoomResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdRoomResponse> getById(Integer id) {
        return null;
    }
}
