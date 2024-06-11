package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddHotelReviewRequest {
    @NotNull(message = "You must enter a hotel id.")
    private Integer hotelId;

    @Min(1)
    @Max(5)
    private int starRating;

    private String description;
}
