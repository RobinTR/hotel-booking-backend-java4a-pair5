package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.user.AddUserRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GuestMapper {
    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    @Mapping(target = "user.id", source = "userId")
    Guest guestFromAddRequest(AddGuestRequest request);

    AddGuestRequest addGuestRequestFromUser(User user);

    Guest guestFromUpdateRequest(UpdateGuestRequest request);

    GetAllGuestResponse getAllGuestResponseMap(Guest guest);

    List<GetAllGuestResponse> getAllGuestResponseList(List<Guest> guests);

    GetByIdGuestResponse getByIdGuestResponse(Guest guest);
}
