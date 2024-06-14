package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
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
    public Response add(AddRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromAddRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_ADDED);
    }

    @Override
    public Response update(UpdateRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromUpdateRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new BusinessException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));
        roomTypeRepository.delete(roomType);

        return new SuccessResponse(RoomTypeMessages.ROOMTYPE_DELETED);
    }

    @Override
    public DataResponse<List<GetAllRoomTypeResponse>> getAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        List<GetAllRoomTypeResponse> response = RoomTypeMapper.INSTANCE.getAllRoomTypeResponseListFromRoomTypes(roomTypes);

        return new SuccessDataResponse<>(response, RoomTypeMessages.ROOMTYPE_LISTED);
    }

    @Override
    public DataResponse<GetByIdRoomTypeResponse> getById(Integer id) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new BusinessException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));
        GetByIdRoomTypeResponse response = RoomTypeMapper.INSTANCE.getByIdRoomTypeResponseFromRoomType(roomType);

        return new SuccessDataResponse<>(response, RoomTypeMessages.ROOMTYPE_LISTED);
    }
}
