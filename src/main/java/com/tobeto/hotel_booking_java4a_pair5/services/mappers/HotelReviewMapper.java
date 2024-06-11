package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetAllHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetByIdHotelReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelReviewMapper {
    HotelReviewMapper INSTANCE = Mappers.getMapper(HotelReviewMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    HotelReview hotelReviewFromAddRequest(AddHotelReviewRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    HotelReview hotelReviewFromUpdateRequest(UpdateHotelReviewRequest request);

    @Mapping(target = "hotelName", source = "hotel.name")
    GetAllHotelReviewResponse getAllHotelReviewResponseMap(HotelReview hotelReview);

    List<GetAllHotelReviewResponse> getAllHotelReviewResponseList(List<HotelReview> hotelReviews);

    @Mapping(target = "hotelName", source = "hotel.name")
    GetByIdHotelReviewResponse getByIdHotelReviewResponse(HotelReview hotelReview);
}
