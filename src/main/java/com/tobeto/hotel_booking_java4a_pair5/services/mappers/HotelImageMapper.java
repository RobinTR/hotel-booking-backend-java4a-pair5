package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelImage;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetHotelImageResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetImageUrlsOfHotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelImageMapper {
    HotelImageMapper INSTANCE = Mappers.getMapper(HotelImageMapper.class);

    @Mapping(target = "hotelId", source = "hotel.id")
    GetHotelImageResponse getHotelImageResponseFromHotelImage(HotelImage hotelImage);

    @Mapping(target = "url", source = "image.url")
    GetImageUrlsOfHotelResponse getImagesUrlOfHotelResponseMap(HotelImage hotelImage);

    List<GetImageUrlsOfHotelResponse> getImagesUrlOfHotelResponseListFromHotelImages(List<HotelImage> hotelImages);
}
