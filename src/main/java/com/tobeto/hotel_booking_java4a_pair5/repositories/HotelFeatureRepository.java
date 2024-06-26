package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelFeatureRepository extends JpaRepository<HotelFeature, Integer> {
    List<HotelFeature> findAllByHotel(Hotel hotel);
}
