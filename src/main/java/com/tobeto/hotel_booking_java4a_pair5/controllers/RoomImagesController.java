package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomImage;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image.GetRoomImageResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomImageMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/roomimages")
@AllArgsConstructor
public class RoomImagesController {
    private final RoomImageService roomImageService;

    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public DataResponse<Object> save(@RequestParam("file") MultipartFile file, @RequestParam Integer roomId) {
        Object object = roomImageService.save(file, roomId);
        GetRoomImageResponse getRoomImageResponse = RoomImageMapper.INSTANCE.getRoomImageResponseFromRoomImage((RoomImage) object);

        return new SuccessDataResponse<>(getRoomImageResponse, ImageMessages.IMAGE_UPLOADED);
    }

    @DeleteMapping("/delete")
    public Response delete(@RequestParam String url) {
        roomImageService.delete(url);

        return new SuccessResponse(ImageMessages.IMAGE_DELETED);
    }
}
