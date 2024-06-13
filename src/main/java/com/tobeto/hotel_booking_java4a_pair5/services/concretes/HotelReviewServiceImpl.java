package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromAddRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return new SuccessResponse(HotelReviewMessages.HOTELREVIEW_ADDED);
    }

    @Override
    public Response update(UpdateHotelReviewRequest request) {
        HotelReview hotelReview = HotelReviewMapper.INSTANCE.hotelReviewFromUpdateRequest(request);
        hotelReview = hotelReviewRepository.save(hotelReview);

        return new SuccessResponse(HotelReviewMessages.HOTELREVIEW_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelReviewMessages.HOTELREVIEW_NOT_FOUND));
        hotelReviewRepository.deleteById(hotelReview.getId());

        return new SuccessDataResponse<>(HotelReviewMessages.HOTELREVIEW_DELETED);
    }

    @Override
    public DataResponse<List<GetAllHotelReviewResponse>> getAll() {
        List<HotelReview> hotelReviews = hotelReviewRepository.findAll();
        List<GetAllHotelReviewResponse> response = HotelReviewMapper.INSTANCE.getAllHotelReviewResponseList(hotelReviews);

        return new SuccessDataResponse<>(response, HotelReviewMessages.HOTELREVIEW_LISTED);
    }

    @Override
    public DataResponse<GetByIdHotelReviewResponse> getById(Integer id) {
        HotelReview hotelReview = hotelReviewRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelReviewMessages.HOTELREVIEW_NOT_FOUND));
        GetByIdHotelReviewResponse response = HotelReviewMapper.INSTANCE.getByIdHotelReviewResponse(hotelReview);

        return new SuccessDataResponse<>(response, HotelReviewMessages.HOTELREVIEW_LISTED);
    }
}
