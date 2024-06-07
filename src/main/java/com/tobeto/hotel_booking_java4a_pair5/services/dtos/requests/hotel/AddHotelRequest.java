package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddHotelRequest {
    @NotNull(message = "You must enter a address id.")
    private Integer addressId;
    @NotNull(message = "You must enter a hotel review id.")
    private Integer hotelReviewId;
    @NotBlank(message = "Hotel name cannot be blank.")
    @Size(min = 8, max = 128, message = "Hotel name must be between 8-128 characters.")
    private String name;
    @NotBlank(message = "Contact number cannot be blank.")
    private String contactNumber;
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "You must enter a valid email.")
    @Size(max = 128, message = "Email must be maximum 128 characters.")
    private String email;
    private String website;
    private String description;
    @Positive(message = "Floor count must be higher than 0.")
    private int floorCount;
    @Size(min = 1, max = 5)
    private int starRating;
}