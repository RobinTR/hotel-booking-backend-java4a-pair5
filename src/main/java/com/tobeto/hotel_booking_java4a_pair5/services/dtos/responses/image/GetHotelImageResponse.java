package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image;

import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetHotelImageResponse {
    private Integer id;
    private Integer hotelId;
    private Image image;
}
