package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelReviewRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelReviewMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelReviewMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelReviewServiceImpl implements HotelReviewService {
    private final HotelReviewRepository hotelReviewRepository;

    @Override
    public HotelReview add(AddHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromAddRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return hotelReview;
    }

    @Override
    public HotelReview update(UpdateHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromUpdateRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return hotelReview;
    }

    @Override
    public String delete(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new BusinessException(HotelReviewMessages.HOTELREVIEW_NOT_FOUND));
        hotelReviewRepository.delete(hotelReview);

        return HotelReviewMessages.HOTELREVIEW_DELETED;
    }

    @Override
    public List<HotelReview> getAll() {
        return hotelReviewRepository.findAll();
    }

    @Override
    public HotelReview getById(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new BusinessException(HotelReviewMessages.HOTELREVIEW_NOT_FOUND));

        return hotelReview;
    }
}
