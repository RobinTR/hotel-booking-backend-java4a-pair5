package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomBookedMapper {
    RoomBookedMapper INSTANCE = Mappers.getMapper(RoomBookedMapper.class);

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "room.id", source = "roomId")
    RoomBooked roomBookedFromAddRequest(AddRoomBookedRequest request);

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "room.id", source = "roomId")
    RoomBooked roomBookedFromUpdateRequest(UpdateRoomBookedRequest request);
}
