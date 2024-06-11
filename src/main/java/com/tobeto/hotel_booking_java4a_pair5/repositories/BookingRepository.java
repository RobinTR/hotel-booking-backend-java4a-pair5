package com.tobeto.hotel_booking_java4a_pair5.repositories;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse(b.id, h.name, g.firstName, pm.name, b.startDate, b.endDate, b.checkInDate, b.checkOutDate, b.totalCost) " +
            "FROM Booking AS b " +
            "INNER JOIN RoomBooked AS rb ON b.id = rb.booking.id " +
            "INNER JOIN Room AS r ON rb.room.id = r.id " +
            "INNER JOIN Hotel AS h ON r.hotel.id = h.id " +
            "INNER JOIN PaymentMethod AS pm ON b.paymentMethod.id = pm.id " +
            "INNER JOIN Guest AS g ON b.guest.id = g.id " +
            "INNER JOIN User AS u ON g.id = u.id " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND r.isAvailable = true)")
    List<GetAllBookingResponse> searchByDate(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse(b.id, h.name, g.firstName, pm.name, b.startDate, b.endDate, b.checkInDate, b.checkOutDate, b.totalCost) " +
            "FROM Booking AS b " +
            "INNER JOIN RoomBooked AS rb ON b.id = rb.booking.id " +
            "INNER JOIN Room AS r ON rb.room.id = r.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = rt.id " +
            "INNER JOIN Hotel AS h ON r.hotel.id = h.id " +
            "INNER JOIN PaymentMethod AS pm ON b.paymentMethod.id = pm.id " +
            "INNER JOIN Guest AS g ON b.guest.id = g.id " +
            "INNER JOIN User AS u ON g.id = u.id " +
            "WHERE rt.id = :roomTypeId " +
            "AND r.isAvailable = TRUE")
    List<GetAllBookingResponse> searchByRoomType(Integer roomTypeId);
}
