package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHotelRequest {
    private Integer id;
    private Integer addressId;
    private Integer hotelReviewId;
    private String name;
    private String contactNumber;
    private String email;
    private String website;
    private String description;
    private Integer floorCount;
    private Integer roomCapacity;
    private Integer startRating;
}
