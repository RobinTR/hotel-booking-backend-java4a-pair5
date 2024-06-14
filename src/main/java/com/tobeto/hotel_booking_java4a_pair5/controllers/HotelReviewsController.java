package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelReview;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelReviewMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetAllHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetByIdHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelReviewMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotelreviews")
@AllArgsConstructor
public class HotelReviewsController {
    private HotelReviewService hotelReviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddHotelReviewRequest request) {
        hotelReviewService.add(request);

        return new SuccessResponse(HotelReviewMessages.HOTELREVIEW_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateHotelReviewRequest request) {
        hotelReviewService.update(request);

        return new SuccessResponse(HotelReviewMessages.HOTELREVIEW_UPDATED);

    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        hotelReviewService.delete(id);

        return new SuccessResponse(HotelReviewMessages.HOTELREVIEW_DELETED);

    }

    @GetMapping
    public DataResponse<List<GetAllHotelReviewResponse>> getAll() {
        List<HotelReview> hotelReview = hotelReviewService.getAll();
        List<GetAllHotelReviewResponse> hotelReviewResponseList = HotelReviewMapper.INSTANCE.getAllHotelReviewResponseList(hotelReview);

        return new SuccessDataResponse<>(hotelReviewResponseList, HotelReviewMessages.HOTELREVIEW_LISTED);
    }


    @GetMapping("/{getById}")
    public DataResponse<GetByIdHotelReviewResponse> getById(@PathVariable Integer getById) {
        HotelReview hotelReview = hotelReviewService.getById(getById);
        GetByIdHotelReviewResponse getByIdHotelReviewResponse = HotelReviewMapper.INSTANCE.getByIdHotelReviewResponse(hotelReview);

        return new SuccessDataResponse<>(getByIdHotelReviewResponse, HotelReviewMessages.HOTELREVIEW_LISTED);
    }
}
