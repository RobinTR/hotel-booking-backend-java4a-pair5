package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetAllRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
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

        return new SuccessResult(RoomMessages.ROOM_ADDED);
    }

    @Override
    public Result update(UpdateRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromUpdateRequest(request);
        room = roomRepository.save(room);

        return new SuccessResult(RoomMessages.ROOM_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomMessages.ROOM_NOT_FOUND));
        roomRepository.delete(room);

        return new SuccessResult(RoomMessages.ROOM_DELETED);
    }

    @Override
    public DataResult<List<GetAllRoomResponse>> getAll() {
        List<Room> rooms = roomRepository.findAll();
        List<GetAllRoomResponse> getAllRoomResponse = RoomMapper.INSTANCE.getAllRoomResponseListFromRooms(rooms);

        return new SuccessDataResult<>(getAllRoomResponse, RoomMessages.ROOM_LISTED);
    }

    @Override
    public DataResult<GetByIdRoomResponse> getById(Integer id) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomMessages.ROOM_NOT_FOUND));
        GetByIdRoomResponse getByIdRoomResponse = RoomMapper.INSTANCE.getByIdRoomResponseFromRoom(room);

        return new SuccessDataResult<>(getByIdRoomResponse, RoomMessages.ROOM_LISTED);
    }
}
