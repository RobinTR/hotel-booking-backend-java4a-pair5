package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer>, JpaSpecificationExecutor<Hotel> {
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
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id " +
            "WHERE LOWER(a.neighborhood.name) LIKE LOWER(:name) OR " +
            "LOWER(a.neighborhood.area.name) LIKE LOWER(:name) OR " +
            "LOWER(a.neighborhood.area.district.name) LIKE LOWER(:name) OR " +
            "LOWER(a.neighborhood.area.district.city.name) LIKE LOWER(:name) OR " +
            "LOWER(a.neighborhood.area.district.city.country.name) LIKE LOWER(:name)")
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
            "LEFT JOIN h.bookings b " +
            "LEFT JOIN h.rooms r " +
            "LEFT JOIN r.roomType rt " +
            "WHERE h.id = :hotelId AND b.reservationStatus = 'ABORTED' OR b.reservationStatus = 'COMPLETED'")
    Hotel findHotelWithAvailableRooms(Integer hotelId);

    @Query("SELECT h FROM Hotel h " +
            "LEFT JOIN h.bookings b " +
            "LEFT JOIN h.rooms r " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND b.reservationStatus = 'ABORTED' OR b.reservationStatus = 'COMPLETED')")
    Hotel searchByBookingDateHotels(LocalDate startDate, LocalDate endDate);

    @Query("SELECT DISTINCT h FROM Hotel h " +
            "INNER JOIN h.rooms r " +
            "WHERE r.roomType.capacity = :person")
    List<Hotel> searchByRoomCapacityHotels(int person);
}
