package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/images")
@AllArgsConstructor
public class ImagesController {
    private final ImageService imageService;

    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public DataResponse<Object> save(@RequestParam("file") MultipartFile file) {
        Object object = imageService.save(file);

        return new SuccessDataResponse<>(object, ImageMessages.IMAGE_UPLOADED);
    }

    @DeleteMapping("/delete")
    public Response delete(@RequestParam String url) {
        imageService.delete(url);

        return new SuccessResponse(ImageMessages.IMAGE_DELETED);
    }
}
