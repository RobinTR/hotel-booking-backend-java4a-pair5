package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdNeighborhoodResponse {
    private Integer id;
    private String areaName;
    private String zipCode;
    private String name;
}
