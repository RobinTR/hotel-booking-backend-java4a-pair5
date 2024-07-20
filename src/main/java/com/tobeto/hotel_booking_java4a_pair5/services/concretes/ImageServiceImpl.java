package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.CloudinaryImageHelperUtil;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.cloudinary.ImageModel;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Image;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ImageRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ImageService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ImageMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.ImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final Cloudinary cloudinary;

    @Override
    public Object save(MultipartFile file) throws IOException {
        Map<?, ?> result;

        result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        ImageModel imageModel = ImageModel.builder()
                .publicId(String.valueOf(result.get("public_id")))
                .url(String.valueOf(result.get("url")))
                .width((Integer) result.get("width"))
                .height((Integer) result.get("height"))
                .build();

        Image image = ImageMapper.INSTANCE.imageFromImageModel(imageModel);
        imageRepository.save(image);

        return image;
    }

    @Override
    public String delete(String url) throws IOException {
        cloudinary.uploader().destroy(CloudinaryImageHelperUtil.getImagePublicIdFromUrl(url), ObjectUtils.emptyMap());

        return ImageMessages.IMAGE_DELETED;
    }
}
