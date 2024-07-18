package com.tobeto.hotel_booking_java4a_pair5.repositories;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT b " +
            "FROM Booking AS b " +
            "INNER JOIN b.roomBooked AS rb " +
            "INNER JOIN rb.room AS r " +
            "INNER JOIN b.hotel AS h " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND b.reservationStatus = 'ABORTED' OR b.reservationStatus = 'COMPLETED')")
    List<Booking> searchByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT b " +
            "FROM Booking AS b " +
            "INNER JOIN RoomBooked AS rb ON b.id = rb.booking.id " +
            "INNER JOIN Room AS r ON rb.room.id = r.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = rt.id " +
            "WHERE rt.id = :roomTypeId " +
            "AND b.reservationStatus = 'ABORTED' OR b.reservationStatus = 'COMPLETED'")
    List<Booking> searchByRoomType(Integer roomTypeId);

    @Query("SELECT b FROM Booking AS b WHERE b.guest.user.id = :userId")
    List<Booking> findAllByUserId(Integer userId);

    @Query("SELECT b FROM Booking AS b " +
            "LEFT JOIN b.hotel AS h" +
            "LEFT JOIN b.hotel.managers AS m " +
            "WHERE m.id = :managerId")
    List<Booking> findAllByManagerId(Integer managerId);
}
