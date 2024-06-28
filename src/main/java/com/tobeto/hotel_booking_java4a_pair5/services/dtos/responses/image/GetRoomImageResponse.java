package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image;

import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRoomImageResponse {
    private Integer id;
    private Integer roomId;
    private Image image;
}
