package com.tobeto.hotel_booking_java4a_pair5.core.configurations;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfiguration {
    @Bean
    public Cloudinary cloudinary() {
        Map config = new HashMap();
        config.put("cloud_name", "dqkkbko4s");
        config.put("api_key", "884823745345536");
        config.put("api_secret", "8ZdhP9KsH-EzduY4rXTNmMfswwY");

        return new Cloudinary(config);
    }
}
