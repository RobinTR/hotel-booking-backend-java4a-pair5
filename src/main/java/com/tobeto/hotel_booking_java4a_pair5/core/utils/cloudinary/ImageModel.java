package com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageModel {
    private Integer id;

    private String url;

    private String publicId;

    private int width;

    private int height;
}
