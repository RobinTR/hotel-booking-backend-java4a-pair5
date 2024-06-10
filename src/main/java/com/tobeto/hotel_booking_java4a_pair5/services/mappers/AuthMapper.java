package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthMapper {
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);

    @Mapping(target = "address.id", source = "addressId")
    User userFromRegisterRequest(RegisterRequest request);
}
