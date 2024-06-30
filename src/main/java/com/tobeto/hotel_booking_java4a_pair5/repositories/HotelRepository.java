package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query("SELECT h FROM Hotel h " +
            "INNER JOIN Booking AS b ON h.id = b.hotel.id " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "INNER JOIN Neighborhood AS n ON a.neighborhood.id = n.id " +
            "INNER JOIN Area AS ar ON n.area.id = ar.id " +
            "INNER JOIN District AS d ON ar.district.id = d.id " +
            "INNER JOIN City AS c ON d.city.id = c.id " +
            "INNER JOIN Country AS co ON c.country.id = co.id " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = r.id WHERE " +
            "h.id = :hotelId AND " +
            "c.name = :location AND " +
            "co.name = :location AND " +
            "d.name = :location AND " +
            "ar.name = :location AND " +
            "r.roomType.capacity = :roomCapacity AND " +
            "b.startDate <= :endDate AND " +
            "b.endDate >= :startDate AND " +
            "r.isAvailable = true")
    Hotel searchByRoomFilters(Integer hotelId, String location,
                              LocalDate startDate,
                              LocalDate endDate,
                              Integer roomCapacity);

    @Query("SELECT h FROM Hotel h " +
            "INNER JOIN Booking AS b ON h.id = b.hotel.id " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "INNER JOIN Neighborhood AS n ON a.neighborhood.id = n.id " +
            "INNER JOIN Area AS ar ON n.area.id = ar.id " +
            "INNER JOIN District AS d ON ar.district.id = d.id " +
            "INNER JOIN City AS c ON d.city.id = c.id " +
            "INNER JOIN Country AS co ON c.country.id = co.id " +
            "INNER JOIN Room AS r ON h.id = r.hotel.id " +
            "INNER JOIN RoomType AS rt ON r.roomType.id = rt.id " +
            "WHERE h.id = :hotelId " +
            "AND (:location IS NULL OR c.name LIKE :location) " +
            "AND (:location IS NULL OR co.name LIKE :location) " +
            "AND (:location IS NULL OR d.name LIKE :location) " +
            "AND (:location IS NULL OR ar.name LIKE :location) " +
            "AND (:location IS NULL OR n.name LIKE :location) " +
            "AND (:roomCapacity IS NULL OR r.roomType.capacity = :roomCapacity) " +
            "AND ((:startDate IS NULL OR :endDate IS NULL) OR (b.startDate <= :endDate AND b.endDate >= :startDate)) " +
            "AND r.isAvailable = true ")
    Hotel searchByRoomFilters2(Integer hotelId,
                               LocalDate startDate,
                               LocalDate endDate,
                               Integer roomCapacity);

    @Query("SELECT DISTINCT h FROM Hotel h " +
            "LEFT JOIN h.bookings b " +
            "LEFT JOIN h.address a " +
            "LEFT JOIN a.neighborhood n " +
            "LEFT JOIN n.area ar " +
            "LEFT JOIN ar.district d " +
            "LEFT JOIN d.city ci " +
            "LEFT JOIN ci.country co " +
            "LEFT JOIN h.rooms r " +
            "WHERE (:hotelId IS NULL OR h.id = :hotelId) " +
            "AND (:location IS NULL OR co.name LIKE :location) " +
            "AND (:location IS NULL OR ci.name LIKE :location) " +
            "AND (:location IS NULL OR d.name LIKE :location) " +
            "AND (:location IS NULL OR ar.name LIKE :location) " +
            "AND (:location IS NULL OR n.name LIKE :location) " +
            "AND (:roomCapacity IS NULL OR r.roomType.capacity = :roomCapacity) " +
            "AND ((:startDate IS NULL OR :endDate IS NULL) OR (b.startDate <= :endDate AND b.endDate >= :startDate)) " +
            "AND r.isAvailable = true ")
    Hotel searchByRoomFilterss(Integer hotelId, String location,
                               LocalDate startDate,
                               LocalDate endDate,
                               Integer roomCapacity);

    @Query("SELECT DISTINCT h FROM Hotel h " +
            "LEFT JOIN FETCH h.bookings b " +
            "LEFT JOIN FETCH h.address a " +
            "LEFT JOIN FETCH a.neighborhood n " +
            "LEFT JOIN FETCH n.area ar " +
            "LEFT JOIN FETCH ar.district d " +
            "LEFT JOIN FETCH d.city c " +
            "LEFT JOIN FETCH c.country co " +
            "LEFT JOIN FETCH h.rooms r " +
            "LEFT JOIN FETCH r.roomType rt " +
            "WHERE h.id = :hotelId " +
            "AND (:roomCapacity IS NULL OR r.roomType.capacity = :roomCapacity) " +
            "AND ((:startDate IS NULL OR :endDate IS NULL) OR (b.startDate <= :endDate AND b.endDate >= :startDate)) " +
            "AND r.isAvailable = true ")
    List<Hotel> searchByRoomFilterss2(Integer hotelId,
                                LocalDate startDate,
                                LocalDate endDate,
                                Integer roomCapacity);

    @Query("SELECT h FROM Hotel h " +
            "LEFT JOIN FETCH h.address a " +
            "LEFT JOIN FETCH a.neighborhood n " +
            "LEFT JOIN FETCH n.area ar " +
            "LEFT JOIN FETCH ar.district d " +
            "LEFT JOIN FETCH d.city c " +
            "LEFT JOIN FETCH c.country co " +
            "WHERE h.id = :hotelId")
    Hotel fetchHotelWithoutCollections(Integer hotelId);

    @Query("SELECT DISTINCT b FROM Booking b " +
            "LEFT JOIN FETCH b.hotel h " +
            "LEFT JOIN FETCH h.rooms r " +
            "WHERE b.hotel.id = :hotelId " +
            "AND (:startDate IS null OR :endDate IS null OR (b.startDate <= cast(:endDate as timestamp) AND b.endDate >= cast(:startDate as timestamp))) " +
            "AND r.isAvailable = true")
    List<Booking> fetchBookingsForHotel(@Param("hotelId") Integer hotelId,
                                        @Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    @Query("SELECT DISTINCT r FROM Room r " +
            "JOIN FETCH r.roomType rt " +
            "WHERE r.hotel.id = :hotelId " +
            "AND (:roomCapacity IS NULL OR rt.capacity = :roomCapacity) " +
            "AND r.isAvailable = true")
    List<Room> fetchRoomsForHotel(@Param("hotelId") Integer hotelId,
                                  @Param("roomCapacity") Integer roomCapacity);

    @Query("SELECT b FROM Booking b " +
            "JOIN b.roomBooked rb " +
            "WHERE b.hotel.id = :hotelId " +
            "AND (:startDate IS NULL OR :endDate IS NULL OR (b.startDate <= :endDate AND b.endDate >= :startDate)) " +
            "AND (:roomCapacity IS NULL OR rb.room.roomType.capacity >= :roomCapacity)")
    List<Booking> findBookingsByHotelIdAndOptionalParams(
            Long hotelId,
            LocalDate startDate,
            LocalDate endDate,
            Integer roomCapacity);


}
