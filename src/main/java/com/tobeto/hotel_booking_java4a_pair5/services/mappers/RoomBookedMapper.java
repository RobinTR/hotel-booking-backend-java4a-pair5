package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetAllRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomBookedMapper {
    RoomBookedMapper INSTANCE = Mappers.getMapper(RoomBookedMapper.class);

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "room.id", source = "roomId")
    RoomBooked roomBookedFromAddRequest(AddRoomBookedRequest request);

    @Mapping(target = "booking.id", source = "bookingId")
    @Mapping(target = "room.id", source = "roomId")
    RoomBooked roomBookedFromUpdateRequest(UpdateRoomBookedRequest request);

    @Mapping(target = "bookingHotelName", source = "booking.hotel.name")
    @Mapping(target = "roomTypeName", source = "room.roomType.name")
    GetAllRoomBookedResponse getAllRoomBookedResponseMap(RoomBooked roomBooked);

    List<GetAllRoomBookedResponse> getAllRoomBookedResponseListFromRoomBooked(List<RoomBooked> roomBooked);

    @Mapping(target = "bookingHotelName", source = "booking.hotel.name")
    @Mapping(target = "roomTypeName", source = "room.roomType.name")
    GetByIdRoomBookedResponse getByIdRoomBookedResponseFromRoomBooked(RoomBooked roomBooked);

    List<GetByIdRoomBookedResponse> getByIdRoomBookedResponseFromRoomBookedList(List<RoomBooked> roomBooked);

    @Mapping(target = "booking.hotel.name", source = "bookingHotelName")
    @Mapping(target = "room.roomType.name", source = "roomTypeName")
    RoomBooked getRoomBookedFromGetByIdRoomBookedResponse(GetByIdRoomBookedResponse response);

    @Mapping(target = "bookingId", source = "booking.id")
    @Mapping(target = "roomId", source = "room.id")
    AddRoomBookedRequest roomBookedFromAddRequest(RoomBooked roomBooked);
}
