package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth.RegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.AddUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userFromAddUserRequest(AddUserRequest addUserRequest);

    AddUserRequest addUserRequest(User user);

    AddUserRequest addUserRequestFromAddUserRequest(RegisterRequest request);

    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetAllUserResponse getAllUserResponseMap(User user);

    List<GetAllUserResponse> getAllUserResponseListFromUser(List<User> users);


    @Mapping(target = "fullAddress", source = "address.fullAddress")
    GetByIdUserResponse getByIdUserResponseFromUser(User user);
}
