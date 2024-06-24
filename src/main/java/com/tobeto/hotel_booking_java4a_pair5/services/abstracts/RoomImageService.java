package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import org.springframework.web.multipart.MultipartFile;

public interface RoomImageService {
    Object save(MultipartFile file, Integer roomId);

    String delete(String url);
}
