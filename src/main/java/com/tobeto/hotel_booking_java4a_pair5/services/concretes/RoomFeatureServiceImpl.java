package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomFeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.AddRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.UpdateRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomFeatureMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.RoomFeatureRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomFeatureServiceImpl implements RoomFeatureService {
    private final RoomFeatureRepository roomFeatureRepository;
    private final RoomService roomService;
    private final RoomFeatureRules roomFeatureRules;

    @Override
    public RoomFeature add(AddRoomFeatureRequest request) {
        RoomFeature roomFeature = RoomFeatureMapper.INSTANCE.roomFeatureFromAddRequest(request);
        roomFeature = roomFeatureRepository.save(roomFeature);

        return roomFeature;
    }

    @Override
    public RoomFeature update(UpdateRoomFeatureRequest request) {
        RoomFeature roomFeature = RoomFeatureMapper.INSTANCE.roomFeatureFromUpdateRequest(request);
        roomFeature = roomFeatureRepository.save(roomFeature);

        return roomFeature;
    }

    @Override
    public String delete(Integer roomId) {
        RoomFeature roomFeature = roomFeatureRules.findById(roomId);
        roomFeatureRepository.delete(roomFeature);

        return RoomFeatureMessages.ROOM_FEATURE_DELETED;
    }

    @Override
    public List<RoomFeature> getAllFeaturesByRoomId(Integer roomId) {
        Room room = roomService.getById(roomId);

        return roomFeatureRepository.findAllByRoom(room);
    }
}
