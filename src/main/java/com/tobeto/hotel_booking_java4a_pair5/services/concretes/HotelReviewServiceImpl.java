package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelReviewRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelReviewMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelReviewMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.HotelReviewRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelReviewServiceImpl implements HotelReviewService {
    private final HotelReviewRepository hotelReviewRepository;
    private final HotelReviewRules hotelReviewRules;

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
        HotelReview hotelReview = hotelReviewRules.findById(id);
        hotelReviewRepository.delete(hotelReview);

        return HotelReviewMessages.HOTEL_REVIEW_DELETED;
    }

    @Override
    public List<HotelReview> getAll() {
        return hotelReviewRepository.findAll();
    }

    @Override
    public HotelReview getById(Integer id) {
        return hotelReviewRules.findById(id);
    }
}
