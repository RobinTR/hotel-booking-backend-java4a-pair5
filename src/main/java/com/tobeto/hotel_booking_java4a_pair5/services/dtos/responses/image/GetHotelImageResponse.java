package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetHotelImageResponse {
    private Integer id;
    private Integer hotelId;
    private Image image;
}
