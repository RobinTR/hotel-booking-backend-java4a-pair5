package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Object save(MultipartFile file);

    String delete(String url);
}
