package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GetAllHotelResponse {
    private Integer id;
    private String addressName;
    private String hotelReviewDescription;
    private String name;
    private String contactNumber;
    private String email;
    private String website;
    private String description;
    private int floorCount;
    private int starRating;

    public GetAllHotelResponse(Integer id, String addressName, String hotelReviewDescription, String name, String contactNumber, String email, String website, String description, int floorCount, int starRating) {
        this.id = id;
        this.addressName = addressName;
        this.hotelReviewDescription = hotelReviewDescription;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.website = website;
        this.description = description;
        this.floorCount = floorCount;
        this.starRating = starRating;
    }
}
