package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT h " +
            "FROM Hotel AS h " +
            "INNER JOIN h.address AS a " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id " +
            "WHERE LOWER(h.name) LIKE LOWER(:name)")
    List<Hotel> searchByHotelName(String name);

    @Query(value = "SELECT h " +
            "FROM Hotel AS h " +
            "INNER JOIN h.address AS a ON h.address.id = a.id " +
            "INNER JOIN h.address.country AS c ON a.country.id=c.id " +
            "INNER JOIN h.address.city AS ci ON a.city.id=ci.id " +
            "INNER JOIN h.address.district AS d ON a.district.id=d.id " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id " +
            "WHERE LOWER(c.name) LIKE LOWER(:name) or " +
            "LOWER(ci.name) LIKE LOWER(:name) or " +
            "LOWER(d.name) LIKE LOWER(:name)  ")
    List<Hotel> searchByLocation(String name);

    @Query(value = "SELECT h " +
            "FROM Hotel AS h " +
            "INNER JOIN h.address AS a ON h.address.id = a.id " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id " +
            "WHERE h.starRating = :star")
    List<Hotel> searchByStarRating(int star);

    @Query(value = "SELECT h " +
            "FROM Hotel AS h " +
            "INNER JOIN h.address AS a ON h.address.id = a.id " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id " +
            "WHERE r.cost BETWEEN :minPrice AND :maxPrice")
    List<Hotel> searchByPrice(double minPrice, double maxPrice);

    @Query("SELECT h FROM Hotel h " +
            "LEFT JOIN h.rooms r " +
            "LEFT JOIN r.roomType rt " +
            "WHERE h.id = :hotelId AND r.isAvailable = true")
    Hotel findHotelWithAvailableRooms(Integer hotelId);

    @Query("SELECT h FROM Hotel h " +
            "LEFT JOIN h.bookings b " +
            "LEFT JOIN h.rooms r " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND r.isAvailable = true)")
    Hotel searchByBookingDateHotels(LocalDate startDate, LocalDate endDate);

    @Query("SELECT DISTINCT h FROM Hotel h " +
            "INNER JOIN h.rooms r " +
            "WHERE r.roomType.capacity = :person")
    List<Hotel> searchByRoomCapacityHotels(int person);
}
