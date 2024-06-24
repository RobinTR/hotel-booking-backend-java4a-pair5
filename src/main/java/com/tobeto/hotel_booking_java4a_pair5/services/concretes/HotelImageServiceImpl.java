package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.CloudinaryImageHelperUtil;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.ImageModel;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HotelImageServiceImpl implements HotelImageService {
    private final ImageRepository imageRepository;
    private final ImageService imageService;
    private final HotelImageRepository hotelImageRepository;
    private final Cloudinary cloudinary;
    private final HotelService hotelService;

    @Override
    public Object save(MultipartFile file, Integer hotelId) {
        Image image = (Image) imageService.save(file);

        Hotel hotel = hotelService.getById(hotelId);

        HotelImage hotelImage = new HotelImage(hotel, image);
        hotelImageRepository.save(hotelImage);

        return hotelImage;
    }

    @Override
    public String delete(String url) {
        try {
            cloudinary.uploader().destroy(CloudinaryImageHelperUtil.getImagePublicIdFromUrl(url), ObjectUtils.emptyMap());
        } catch (IOException e) {
            return ImageMessages.IMAGE_DELETE_ERROR;
        }

        return ImageMessages.IMAGE_DELETED;
    }
}
