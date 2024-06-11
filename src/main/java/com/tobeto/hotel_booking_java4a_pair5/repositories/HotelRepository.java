package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse(h.id, a.fullAddress, h.name, h.contactNumber, h.email, h.website, h.description, h.floorCount, h.starRating) " +
            "FROM Hotel AS h " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "WHERE LOWER(h.name) LIKE LOWER(:name)")
    List<GetAllHotelResponse> searchByHotelName(String name);

    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse(h.id, a.fullAddress, h.name, h.contactNumber, h.email, h.website, h.description, h.floorCount, h.starRating) " +
            "FROM Hotel AS h " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "INNER JOIN Country AS c ON a.country.id=c.id " +
            "INNER JOIN City AS ci ON a.city.id=ci.id " +
            "INNER JOIN District AS d ON a.district.id=d.id " +
            "WHERE LOWER(c.name) LIKE LOWER(:name) or " +
            "LOWER(ci.name) LIKE LOWER(:name) or " +
            "LOWER(d.name) LIKE LOWER(:name)  ")
    List<GetAllHotelResponse> searchByLocation(String name);

    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse(h.id, a.fullAddress, h.name, h.contactNumber, h.email, h.website, h.description, h.floorCount, h.starRating) " +
            "FROM Hotel AS h " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "WHERE h.starRating = :star")
    List<GetAllHotelResponse> searchByStarRating(int star);
}
