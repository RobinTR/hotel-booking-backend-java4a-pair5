package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "address.id", source = "addressId")
    Manager managerFromAddRequest(AddManagerRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "address.id", source = "addressId")
    Manager managerFromUpdateRequest(UpdateManagerRequest request);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetAllManagerResponse getAllManagerResponseMap(Manager manager);

    List<GetAllManagerResponse> getAllManagerResponseList(List<Manager> managers);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetByIdManagerResponse getByIdManagerResponse(Manager manager);
}
