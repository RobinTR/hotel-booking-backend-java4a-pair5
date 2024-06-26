package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomTypeFeature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomTypeFeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomTypeFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.AddRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.UpdateRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomTypeFeatureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomTypeFeatureServiceImpl implements RoomTypeFeatureService {
    private final RoomTypeFeatureRepository roomTypeFeatureRepository;
    private final RoomTypeService roomTypeService;

    @Override
    public RoomTypeFeature add(AddRoomTypeFeatureRequest request) {
        RoomTypeFeature roomTypeFeature = RoomTypeFeatureMapper.INSTANCE.roomTypeFeatureFromAddRequest(request);
        roomTypeFeature = roomTypeFeatureRepository.save(roomTypeFeature);

        return roomTypeFeature;
    }

    @Override
    public RoomTypeFeature update(UpdateRoomTypeFeatureRequest request) {
        RoomTypeFeature roomTypeFeature = RoomTypeFeatureMapper.INSTANCE.roomTypeFeatureFromUpdateRequest(request);
        roomTypeFeature = roomTypeFeatureRepository.save(roomTypeFeature);

        return roomTypeFeature;
    }

    @Override
    public String delete(Integer roomTypeId) {
        RoomTypeFeature roomTypeFeature = roomTypeFeatureRepository.findById(roomTypeId).orElseThrow(() -> new BusinessException(RoomTypeFeatureMessages.ROOM_TYPE_FEATURE_NOT_FOUND));
        roomTypeFeatureRepository.delete(roomTypeFeature);

        return RoomTypeFeatureMessages.ROOM_TYPE_FEATURE_DELETED;
    }

    @Override
    public List<RoomTypeFeature> getAllFeaturesByRoomTypeId(Integer roomTypeId) {
        RoomType roomType = roomTypeService.getById(roomTypeId);
        List<RoomTypeFeature> roomTypeFeatures = roomTypeFeatureRepository.findAllByRoomType(roomType);

        return roomTypeFeatures;
    }
}
