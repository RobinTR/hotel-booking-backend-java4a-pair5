package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT NEW  com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse(h.id, a.fullAddress, hr.description, h.name, h.contactNumber, h.email, h.website, h.description, h.floorCount, h.starRating) " +
            "FROM Hotel AS h " +
            "INNER JOIN Address AS a ON h.address.id = a.id " +
            "INNER JOIN HotelReview AS hr ON h.hotelReview.id=hr.id " +
            "WHERE LOWER(h.name) LIKE LOWER(:name)")
    List<GetAllHotelResponse> searchByHotelName(String name);
}
