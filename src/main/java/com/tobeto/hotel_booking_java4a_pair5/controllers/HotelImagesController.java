package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelImage;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetHotelImageResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/hotelimages")
@AllArgsConstructor
public class HotelImagesController {
    private final HotelImageService hotelImageService;

    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public DataResponse<Object> save(@RequestParam("file") MultipartFile file, @RequestParam Integer hotelId) throws IOException {
        Object object = hotelImageService.save(file, hotelId);
        GetHotelImageResponse getHotelImageResponse = HotelImageMapper.INSTANCE.getHotelImageResponseFromHotelImage((HotelImage) object);

        return new SuccessDataResponse<>(getHotelImageResponse, ImageMessages.IMAGE_UPLOADED);
    }

    @DeleteMapping("/delete")
    public Response delete(@RequestParam String url) throws IOException {
        hotelImageService.delete(url);

        return new SuccessResponse(ImageMessages.IMAGE_DELETED);
    }
}
