package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelReviewRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelReviewMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetAllHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetByIdHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelReviewMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelReviewServiceImpl implements HotelReviewService {
    private HotelReviewRepository hotelReviewRepository;


    @Override
    public Result add(AddHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromAddRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return new SuccessResult(HotelReviewMessages.HOTELREVİEW_ADDED);
    }

    @Override
    public Result update(UpdateHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromUpdateRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return new SuccessResult(HotelReviewMessages.HOTELREVİEW_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelReviewMessages.HOTELREVİEW_NOT_FOUND));
        hotelReviewRepository.deleteById(hotelReview.getId());

        return new SuccessDataResult<>(HotelReviewMessages.HOTELREVİEW_DELETED);
    }

    @Override
    public DataResult<List<GetAllHotelReviewResponse>> getAll() {
        List<HotelReview> hotelReviews = hotelReviewRepository.findAll();
        List<GetAllHotelReviewResponse> response = HotelReviewMapper.INSTANCE.getAllHotelReviewResponseList(hotelReviews);

        return new SuccessDataResult<>(response, HotelReviewMessages.HOTELREVİEW_LISTED);
    }

    @Override
    public DataResult<GetByIdHotelReviewResponse> getById(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelReviewMessages.HOTELREVİEW_NOT_FOUND));
        GetByIdHotelReviewResponse response = HotelReviewMapper.INSTANCE.getByIdHotelReviewResponse(hotelReview);

        return new SuccessDataResult<>(response, HotelReviewMessages.HOTELREVİEW_LISTED);
    }
}
