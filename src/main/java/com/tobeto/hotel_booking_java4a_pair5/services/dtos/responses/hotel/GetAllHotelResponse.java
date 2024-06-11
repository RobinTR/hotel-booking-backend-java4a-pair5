package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllHotelResponse {
    private Integer id;
    private String addressName;
    private double roomCost;
    private String roomTypeName;
    private String roomTypeDescription;
    private int roomTypeCapacity;
    private String name;
    private String contactNumber;
    private String email;
    private String website;
    private String description;
    private int floorCount;
    private int starRating;

    public GetAllHotelResponse(Integer id, String addressName, String name, String contactNumber, String email, String website, String description, int floorCount, int starRating) {
        this.id = id;
        this.addressName = addressName;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.website = website;
        this.description = description;
        this.floorCount = floorCount;
        this.starRating = starRating;
    }
}
