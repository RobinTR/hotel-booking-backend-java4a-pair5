package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelFeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelFeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.AddHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.UpdateHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature.GetAllHotelFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelFeatureMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotelfeatures")
@AllArgsConstructor
public class HotelFeaturesController {
    private HotelFeatureService hotelFeatureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddHotelFeatureRequest request) {
        hotelFeatureService.add(request);

        return new SuccessResponse(HotelFeatureMessages.HOTEL_FEATURE_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateHotelFeatureRequest request) {
        hotelFeatureService.update(request);

        return new SuccessResponse(HotelFeatureMessages.HOTEL_FEATURE_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        String message = hotelFeatureService.delete(id);

        return new SuccessResponse(message);
    }

    @GetMapping
    public DataResponse<List<GetAllHotelFeatureResponse>> getAll(@RequestParam Integer hotelId) {
        List<HotelFeature> hotelFeatures = hotelFeatureService.getAllFeaturesByHotelId(hotelId);
        List<GetAllHotelFeatureResponse> getAllHotelFeatureResponseList = HotelFeatureMapper.INSTANCE.getAllResponseFromHotelFeatureList(hotelFeatures);

        return new SuccessDataResponse<>(getAllHotelFeatureResponseList, HotelFeatureMessages.HOTEL_FEATURE_LISTED);
    }
}
