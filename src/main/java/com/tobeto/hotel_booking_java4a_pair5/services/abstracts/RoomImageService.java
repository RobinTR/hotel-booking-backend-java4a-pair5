package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RoomImageService {
    Object save(MultipartFile file, Integer roomId) throws IOException;

    String delete(String url) throws IOException;
}
