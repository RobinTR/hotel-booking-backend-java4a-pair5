package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Integer> {
    List<RoomFeature> findAllByRoom(Room room);
}
