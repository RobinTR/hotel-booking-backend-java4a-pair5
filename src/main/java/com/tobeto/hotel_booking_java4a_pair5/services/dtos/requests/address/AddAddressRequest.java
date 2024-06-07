package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressRequest {
    @NotNull(message = "You must enter a country id.")
    private Integer countryId;
    @NotNull(message = "You must enter a city id.")
    private Integer cityId;
    @NotNull(message = "You must enter a district id.")
    private Integer districtId;
    @NotNull(message = "You must enter an area id.")
    private Integer areaId;
    @NotNull(message = "You must enter a neighborhood id.")
    private Integer neighborhoodId;
    @NotBlank(message = "Full address cannot be blank.")
    private String fullAddress;
}
