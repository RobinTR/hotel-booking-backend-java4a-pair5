package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelMapper {
    HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

    @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "hotelReview.id", source = "hotelReviewId")
    Hotel hotelFromAddRequest(AddHotelRequest request);

    @Mapping(target = "address.id", source = "addressId")
    @Mapping(target = "hotelReview.id", source = "hotelReviewId")
    Hotel hotelFromUpdateRequest(UpdateHotelRequest request);

    @Mapping(target = "addressName", source = "address.fullAddress")
    @Mapping(target = "hotelReviewDescription", source = "hotelReview.description")
    GetAllHotelResponse getAllHotelResponseMap(Hotel hotel);

    List<GetAllHotelResponse> getAllHotelResponseList(List<Hotel> hotels);

    @Mapping(target = "addressName", source = "address.fullAddress")
    @Mapping(target = "hotelReviewDescription", source = "hotelReview.description")
    GetByIdHotelResponse getByIdHotelResponse(Hotel hotel);
}
