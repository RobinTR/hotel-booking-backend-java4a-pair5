package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

//    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetAllRoomResponse(h.name,r.number,r.isAvailable,rt.name,rt.description,rt.cost,rt.capacity,rt.smokeFriendly,rt.petFriendly,rt.wifi,rt.food,rt.isAllInclusive) " +
//            "FROM Room AS r " +
//            "INNER JOIN Hotel AS h ON r.hotel.id = h.id " +
//            "INNER JOIN RoomType AS rt ON r.roomType.id=rt.id " +
//            "WHERE LOWER(rt.name) LIKE LOWER(:name)")
//    List<GetAllRoomResponse> searchByRoomType(String name);
}
