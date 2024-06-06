package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GuestMapper {
    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    @Mapping(target = "paymentByCard.id", source = "paymentByCardId")
    Guest guestFromAddRequest(AddGuestRequest request);

    @Mapping(target = "paymentByCard.id", source = "paymentByCardId")
    Guest guestFromUpdateRequest(UpdateGuestRequest request);
}
