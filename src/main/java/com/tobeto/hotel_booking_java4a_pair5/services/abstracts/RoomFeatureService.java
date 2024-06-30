package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.AddRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.UpdateRoomFeatureRequest;

import java.util.List;

public interface RoomFeatureService {
    RoomFeature add(AddRoomFeatureRequest request);

    RoomFeature update(UpdateRoomFeatureRequest request);

    String delete(Integer roomId);

    List<RoomFeature> getAllFeaturesByRoomId(Integer roomId);
}
