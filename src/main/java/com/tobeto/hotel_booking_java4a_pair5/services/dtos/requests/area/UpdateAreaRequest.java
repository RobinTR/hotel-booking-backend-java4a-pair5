package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAreaRequest {
    private Integer id;

    private Integer districtId;

    private String name;
}
