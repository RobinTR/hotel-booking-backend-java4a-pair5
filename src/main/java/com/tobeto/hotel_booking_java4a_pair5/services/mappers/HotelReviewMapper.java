package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelReviewMapper {
    HotelReviewMapper INSTANCE = Mappers.getMapper(HotelReviewMapper.class);

    HotelReview hotelReviewFromAddRequest(AddHotelReviewRequest request);

    HotelReview hotelReviewFromUpdateRequest(UpdateHotelReviewRequest request);
}
