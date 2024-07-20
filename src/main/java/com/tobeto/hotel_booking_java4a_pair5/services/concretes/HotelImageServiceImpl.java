package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.CloudinaryImageHelperUtil;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelImage;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class HotelImageServiceImpl implements HotelImageService {
    private final HotelImageRepository hotelImageRepository;
    private final ImageService imageService;
    private final Cloudinary cloudinary;
    private final HotelService hotelService;

    @Override
    public Object save(MultipartFile file, Integer hotelId) throws IOException {
        Image image = (Image) imageService.save(file);
        Hotel hotel = hotelService.getById(hotelId);

        HotelImage hotelImage = new HotelImage(hotel, image);
        hotelImageRepository.save(hotelImage);

        return hotelImage;
    }

    @Override
    public String delete(String url) throws IOException {
        cloudinary.uploader().destroy(CloudinaryImageHelperUtil.getImagePublicIdFromUrl(url), ObjectUtils.emptyMap());

        return ImageMessages.IMAGE_DELETED;
    }
}
