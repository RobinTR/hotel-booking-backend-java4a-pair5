package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomTypeRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    @Override
    public RoomType add(AddRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromAddRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return roomType;
    }

    @Override
    public RoomType update(UpdateRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromUpdateRequest(request);
        roomType = roomTypeRepository.save(roomType);

        return roomType;
    }

    @Override
    public String delete(Integer id) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new BusinessException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));
        roomTypeRepository.delete(roomType);

        return RoomTypeMessages.ROOMTYPE_DELETED;
    }

    @Override
    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();

    }

    @Override
    public RoomType getById(Integer id) {
        RoomType roomType = roomTypeRepository.findById(id).orElseThrow(() -> new BusinessException(RoomTypeMessages.ROOMTYPE_NOT_FOUND));

        return roomType;
    }
}
