package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "hotelReview.id", source = "hotelReviewId")
    Hotel hotelFromAddRequest(AddHotelRequest request);

    @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "hotelReview.id", source = "hotelReviewId")
    Hotel hotelFromUpdateRequest(UpdateHotelRequest request);
}
