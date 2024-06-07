package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllHotelReviewResponse {
    private Integer id;
    private int starRating;
    private String description;
}
