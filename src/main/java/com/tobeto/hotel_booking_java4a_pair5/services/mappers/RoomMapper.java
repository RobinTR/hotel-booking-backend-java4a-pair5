package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetAllRoomResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.GetByIdRoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "roomType.id", source = "roomTypeId")
    Room roomFromAddRequest(AddRoomRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "roomType.id", source = "roomTypeId")
    Room roomFromUpdateRequest(UpdateRoomRequest request);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "roomTypeName", source = "roomType.name")
    GetAllRoomResponse getAllRoomResponseMap(Room room);

    List<GetAllRoomResponse> getAllRoomResponseListFromRooms(List<Room> rooms);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "roomTypeName", source = "roomType.name")
    GetByIdRoomResponse getByIdRoomResponseFromRoom(Room room);
}
