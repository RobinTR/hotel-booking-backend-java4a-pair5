package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomTypeFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.AddRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.UpdateRoomTypeFeatureRequest;

import java.util.List;

public interface RoomTypeFeatureService {
    RoomTypeFeature add(AddRoomTypeFeatureRequest request);

    RoomTypeFeature update(UpdateRoomTypeFeatureRequest request);

    String delete(Integer roomTypeId);

    List<RoomTypeFeature> getAllFeaturesByRoomTypeId(Integer roomTypeId);
}
