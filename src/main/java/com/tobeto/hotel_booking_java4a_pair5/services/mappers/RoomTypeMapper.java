package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.AddRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype.UpdateRoomTypeRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetAllRoomTypeResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    RoomTypeMapper INSTANCE = Mappers.getMapper(RoomTypeMapper.class);

    RoomType roomTypeFromAddRequest(AddRoomTypeRequest request);

    RoomType roomTypeFromUpdateRequest(UpdateRoomTypeRequest request);

    GetAllRoomTypeResponse getAllRoomTypeResponseMap(RoomType roomType);

    List<GetAllRoomTypeResponse> getAllRoomTypeResponseListFromRoomTypes(List<RoomType> roomTypes);

    GetByIdRoomTypeResponse getByIdRoomTypeResponseFromRoomType(RoomType roomType);
}
