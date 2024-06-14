package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;

import java.util.List;

public interface HotelService {
    Hotel add(AddHotelRequest request);

    Hotel update(UpdateHotelRequest request);

    String delete(Integer id);

    List<Hotel> getAll();

    Hotel getById(Integer id);

    List<Hotel> searchByHotelName(String name);

    List<Hotel> searchByLocation(String name);

    List<Hotel> searchByStarRating(int star);

    List<Hotel> searchByPrice(double minPrice, double maxPrice);
}
