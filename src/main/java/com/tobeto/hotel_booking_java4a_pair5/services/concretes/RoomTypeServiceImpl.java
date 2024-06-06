package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomTypeRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetAllRoomTypeResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
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
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));
        roomTypeRepository.delete(roomType);

        return new SuccessResult(RoomTypeMessages.ROOMTYPE_DELETED);
    }

    @Override
    public DataResult<List<GetAllRoomTypeResponse>> getAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        List<GetAllRoomTypeResponse> response = RoomTypeMapper.INSTANCE.getAllRoomTypeResponseListFromRoomTypes(roomTypes);

        return new SuccessDataResult<>(response, RoomTypeMessages.ROOMTYPE_LISTED);
    }

    @Override
    public DataResult<GetByIdRoomTypeResponse> getById(Integer id) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));
        GetByIdRoomTypeResponse response = RoomTypeMapper.INSTANCE.getByIdRoomTypeResponseFromRoomType(roomType);

        return new SuccessDataResult<>(response, RoomTypeMessages.ROOMTYPE_LISTED);
    }
}
