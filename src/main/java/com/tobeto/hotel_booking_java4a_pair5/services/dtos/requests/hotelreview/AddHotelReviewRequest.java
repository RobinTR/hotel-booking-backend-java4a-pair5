package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddHotelReviewRequest {
    private int starRating;
    private String description;
}
