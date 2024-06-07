package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddHotelReviewRequest {
    @Size(min = 1, max = 5)
    private int starRating;
    private String description;
}
