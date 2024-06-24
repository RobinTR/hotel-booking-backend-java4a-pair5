package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import org.springframework.web.multipart.MultipartFile;

public interface HotelImageService {
    Object save(MultipartFile file, Integer hotelId);

    String delete(String url);
}
