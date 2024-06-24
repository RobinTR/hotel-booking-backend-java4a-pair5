package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.CloudinaryImageHelperUtil;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.ImageModel;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomImage;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomImageService;
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
public class RoomImageServiceImpl implements RoomImageService {
    private final ImageRepository imageRepository;
    private final RoomImageRepository roomImageRepository;
    private final Cloudinary cloudinary;
    private final RoomService roomService;

    @Override
    public Object save(MultipartFile file, Integer roomId) {
        Map<?, ?> result;

        try {
            result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        } catch (Exception e) {
            return new BusinessException(ImageMessages.IMAGE_UPLOAD_ERROR);
        }

        ImageModel imageModel = ImageModel.builder()
                .publicId(String.valueOf(result.get("public_id")))
                .url(String.valueOf(result.get("url")))
                .width((Integer) result.get("width"))
                .height((Integer) result.get("height"))
                .build();
        Image image = ImageMapper.INSTANCE.imageFromImageModel(imageModel);
        image = imageRepository.save(image);

        Room room = roomService.getById(roomId);

        RoomImage roomImage = new RoomImage(room, image);
        roomImageRepository.save(roomImage);

        return roomImage;
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
