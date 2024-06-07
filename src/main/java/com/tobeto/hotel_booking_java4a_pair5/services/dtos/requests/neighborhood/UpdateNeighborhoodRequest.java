package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNeighborhoodRequest {
    private Integer id;

    private Integer areaId;

    private String zipCode;

    private String name;
}

