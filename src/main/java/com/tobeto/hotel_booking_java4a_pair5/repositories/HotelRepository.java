package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.FindHotelWithAvailableRoomsResponse;
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
            "INNER JOIN h.address AS a " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = rt.id " +
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
            "INNER JOIN h.rooms r ON h.id = r.hotel.id " +
            "INNER JOIN r.roomBooked rb ON r.id = rb.room.id " +
            "INNER JOIN rb.booking b ON rb.booking.id = b.id " +
            "WHERE (b.startDate <= :endDate AND b.endDate >= :startDate " +
            "AND (b.reservationStatus = 'PENDING' OR b.reservationStatus = 'COMPLETED')) ")
    Hotel searchByBookingDateHotels(LocalDate startDate, LocalDate endDate);

    @Query("SELECT DISTINCT h FROM Hotel h " +
            "INNER JOIN h.rooms r " +
            "WHERE r.roomType.capacity = :person")
    List<Hotel> searchByRoomCapacityHotels(int person);

    /*
        @Query("SELECT DISTINCT h FROM Hotel h " +
            "LEFT JOIN h.bookings b " +
            "LEFT JOIN h.address a " +
            "LEFT JOIN a.neighborhood n " +
            "LEFT JOIN n.area ar " +
            "LEFT JOIN ar.district d " +
            "LEFT JOIN d.city ci " +
            "LEFT JOIN ci.country co " +
            "LEFT JOIN h.rooms r " +
            "LEFT JOIN r.roomBooked rb " +
            "WHERE (:hotelId IS NULL OR h.id = :hotelId) " +
            "AND (:location IS NULL OR co.name LIKE :location) " +
            "AND (:location IS NULL OR ci.name LIKE :location) " +
            "AND (:location IS NULL OR d.name LIKE :location) " +
            "AND (:location IS NULL OR ar.name LIKE :location) " +
            "AND (:location IS NULL OR n.name LIKE :location) " +
            "AND (:roomCapacity IS NULL OR r.roomType.capacity = :roomCapacity) " +
            "AND ((:startDate IS NULL OR :endDate IS NULL) OR (b.startDate <= :endDate AND b.endDate >= :startDate))")
    Hotel searchByRoomFilterss(Integer hotelId, String location,
                               LocalDate startDate,
                               LocalDate endDate,
                               Integer roomCapacity);
     */
}
