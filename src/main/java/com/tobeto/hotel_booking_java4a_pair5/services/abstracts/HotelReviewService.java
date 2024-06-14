package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;

import java.util.List;

public interface HotelReviewService {
    HotelReview add(AddHotelReviewRequest request);

    HotelReview update(UpdateHotelReviewRequest request);

    String delete(Integer id);

    List<HotelReview> getAll();

    HotelReview getById(Integer id);
}
