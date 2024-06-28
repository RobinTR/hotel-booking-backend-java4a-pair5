package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelFeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.AddHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.UpdateHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelFeatureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelFeatureServiceImpl implements HotelFeatureService {
    private final HotelFeatureRepository hotelFeatureRepository;
    private final HotelService hotelService;

    @Override
    public HotelFeature add(AddHotelFeatureRequest request) {
        HotelFeature hotelFeature = HotelFeatureMapper.INSTANCE.hotelFeatureFromAddRequest(request);
        hotelFeature = hotelFeatureRepository.save(hotelFeature);

        return hotelFeature;
    }

    @Override
    public HotelFeature update(UpdateHotelFeatureRequest request) {
        HotelFeature hotelFeature = HotelFeatureMapper.INSTANCE.hotelFeatureFromUpdateRequest(request);
        hotelFeature = hotelFeatureRepository.save(hotelFeature);

        return hotelFeature;
    }

    @Override
    public String delete(Integer hotelId) {
        HotelFeature hotelFeature = hotelFeatureRepository.findById(hotelId).orElseThrow(() -> new BusinessException(HotelFeatureMessages.HOTEL_FEATURE_NOT_FOUND));
        hotelFeatureRepository.delete(hotelFeature);

        return HotelFeatureMessages.HOTEL_FEATURE_DELETED;
    }

    @Override
    public List<HotelFeature> getAllFeaturesByHotelId(Integer hotelId) {
        Hotel hotel = hotelService.getById(hotelId);
        List<HotelFeature> hotelFeatures = hotelFeatureRepository.findAllByHotel(hotel);

        return hotelFeatures;
    }
}