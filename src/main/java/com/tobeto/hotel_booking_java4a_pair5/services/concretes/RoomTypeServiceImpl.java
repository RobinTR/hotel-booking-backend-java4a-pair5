package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.*;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomTypeRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.*;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    @Override
    public Result add(AddRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromAddRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return new SuccessResult(RoomTypeMessages.ROOMTYPE_ADDED);
    }

    @Override
    public Result update(UpdateRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromUpdateRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return new SuccessResult(RoomTypeMessages.ROOMTYPE_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllRoomTypeResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdRoomTypeResponse> getById(Integer id) {
        return null;
    }
}
