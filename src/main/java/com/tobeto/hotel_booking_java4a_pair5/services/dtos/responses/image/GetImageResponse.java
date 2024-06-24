package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.image;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetImageResponse {
    private Integer id;
    private String url;
    private String publicId;
    private int width;
    private int height;
}
