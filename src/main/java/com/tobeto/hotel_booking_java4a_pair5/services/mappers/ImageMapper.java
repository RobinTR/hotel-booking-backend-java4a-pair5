package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.ImageModel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelImage;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.FindHotelWithAvailableRoomsResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetImageUrlsOfHotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    Image imageFromImageModel(ImageModel imageModel);
}
