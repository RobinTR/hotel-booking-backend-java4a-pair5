package com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary;

public class CloudinaryImageHelperUtil {
    public static String getImagePublicIdFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }
}
