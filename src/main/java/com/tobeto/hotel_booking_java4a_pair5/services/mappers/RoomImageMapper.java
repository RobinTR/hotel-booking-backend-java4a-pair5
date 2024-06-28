package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomImage;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetRoomImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomImageMapper {
    RoomImageMapper INSTANCE = Mappers.getMapper(RoomImageMapper.class);

    @Mapping(target = "roomId", source = "room.id")
    GetRoomImageResponse getRoomImageResponseFromRoomImage(RoomImage roomImage);
}
