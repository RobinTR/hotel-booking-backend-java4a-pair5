package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelReviewService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.AddHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelreview.UpdateHotelReviewRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetAllHotelReviewResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelreview.GetByIdHotelReviewResponse;
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
    public Result add(@RequestBody @Valid AddHotelReviewRequest request) {
        return hotelReviewService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateHotelReviewRequest request) {
        return hotelReviewService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return hotelReviewService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllHotelReviewResponse>> getAll() {
        return hotelReviewService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdHotelReviewResponse> getById(@PathVariable Integer getById) {
        return hotelReviewService.getById(getById);
    }
}
