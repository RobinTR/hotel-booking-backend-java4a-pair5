package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GuestMapper {
    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    @Mapping(target = "paymentByCard.id", source = "paymentByCardId")
    @Mapping(target = "address.id", source = "addressId")
    Guest guestFromAddRequest(AddGuestRequest request);

    @Mapping(target = "paymentByCard.id", source = "paymentByCardId")
    @Mapping(target = "address.id", source = "addressId")
    Guest guestFromUpdateRequest(UpdateGuestRequest request);

    @Mapping(target = "paymentByCardName", source = "paymentByCard.paymentMethod.name")
    GetAllGuestResponse getAllGuestResponseMap(Guest guest);

    List<GetAllGuestResponse> getAllGuestResponseList(List<Guest> guests);

    @Mapping(target = "paymentByCardName", source = "paymentByCard.paymentMethod.name")
    GetByIdGuestResponse getByIdGuestResponse(Guest guest);
}
