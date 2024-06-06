package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "type.id", source = "roomTypeId")
    Room roomFromAddRequest(AddRoomRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "type.id", source = "roomTypeId")
    Room roomFromUpdateRequest(UpdateRoomRequest request);
}
