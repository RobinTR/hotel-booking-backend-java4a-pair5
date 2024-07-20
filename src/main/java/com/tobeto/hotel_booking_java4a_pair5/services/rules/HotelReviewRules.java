package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelReviewRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelReviewMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelReviewRules {
    private final HotelReviewRepository hotelReviewRepository;

    public HotelReview findById(Integer id) {
        return hotelReviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HotelReviewMessages.HOTEL_REVIEW_NOT_FOUND));
    }
}
