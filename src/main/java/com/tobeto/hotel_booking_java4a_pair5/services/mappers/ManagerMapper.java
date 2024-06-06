package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    Manager managerFromAddRequest(AddManagerRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    Manager managerFromUpdateRequest(UpdateManagerRequest request);
}
