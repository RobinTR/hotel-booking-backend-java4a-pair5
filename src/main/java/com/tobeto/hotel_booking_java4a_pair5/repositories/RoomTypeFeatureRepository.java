package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomTypeFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeFeatureRepository extends JpaRepository<RoomTypeFeature, Integer> {
    List<RoomTypeFeature> findAllByRoomType(RoomType roomType);
}
