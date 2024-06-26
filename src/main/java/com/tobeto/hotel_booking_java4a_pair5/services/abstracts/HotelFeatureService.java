package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.AddHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.UpdateHotelFeatureRequest;

import java.util.List;

public interface HotelFeatureService {
    HotelFeature add(AddHotelFeatureRequest request);

    HotelFeature update(UpdateHotelFeatureRequest request);

    String delete(Integer hotelId);

    List<HotelFeature> getAllFeaturesByHotelId(Integer hotelId);
}
