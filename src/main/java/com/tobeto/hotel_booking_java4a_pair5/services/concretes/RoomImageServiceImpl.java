package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.CloudinaryImageHelperUtil;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomImage;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RoomImageServiceImpl implements RoomImageService {
    private final RoomImageRepository roomImageRepository;
    private final ImageService imageService;
    private final Cloudinary cloudinary;
    private final RoomService roomService;

    @Override
    public Object save(MultipartFile file, Integer roomId) throws IOException {
        Image image = (Image) imageService.save(file);
        Room room = roomService.getById(roomId);

        RoomImage roomImage = new RoomImage(room, image);
        roomImageRepository.save(roomImage);

        return roomImage;
    }

    @Override
    public String delete(String url) throws IOException {
        cloudinary.uploader().destroy(CloudinaryImageHelperUtil.getImagePublicIdFromUrl(url), ObjectUtils.emptyMap());

        return ImageMessages.IMAGE_DELETED;
    }
}
