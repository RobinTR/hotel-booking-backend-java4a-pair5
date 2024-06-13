package com.tobeto.hotel_booking_java4a_pair5.repositories;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT b " +
            "FROM Booking AS b " +
            "INNER JOIN b.roomBooked AS rb " +
            "INNER JOIN rb.room AS r " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND r.isAvailable = true)")
    List<Booking> searchByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT b " +
            "FROM Booking AS b " +
            "INNER JOIN RoomBooked AS rb ON b.id = rb.booking.id " +
            "INNER JOIN Room AS r ON rb.room.id = r.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = rt.id " +
            "WHERE rt.id = :roomTypeId " +
            "AND r.isAvailable = TRUE")
    List<Booking> searchByRoomType(Integer roomTypeId);
}
