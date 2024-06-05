package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelReviewRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetAllHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetByIdHotelReviewResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelReviewServiceImpl implements HotelReviewService {
    private HotelReviewRepository hotelReviewRepository;


    @Override
    public Result add(AddHotelReviewRequest request) {
        return null;
    }

    @Override
    public Result update(UpdateHotelReviewRequest request) {
        return null;
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllHotelReviewResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdHotelReviewResponse> getById(Integer id) {
        return null;
    }
}
