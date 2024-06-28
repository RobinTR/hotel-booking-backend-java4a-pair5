package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetImageUrlsOfRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetByIdRoomForHotelResponse {
    private Integer id;
    private GetByIdRoomTypeResponse roomType;
    private List<GetImageUrlsOfRoomResponse> imageUrls;
    private int number;
    private double cost;
    private boolean isAvailable;
}
