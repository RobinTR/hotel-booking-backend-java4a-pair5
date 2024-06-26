package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.FeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.FeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.AddFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.UpdateFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetAllFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetByIdFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.FeatureMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
@AllArgsConstructor
public class FeaturesController {
    private FeatureService featureService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddFeatureRequest request) {
        featureService.add(request);

        return new SuccessResponse(FeatureMessages.FEATURE_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateFeatureRequest request) {
        featureService.update(request);

        return new SuccessResponse(FeatureMessages.FEATURE_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        String message = featureService.delete(id);

        return new SuccessResponse(message);
    }

    @GetMapping
    public DataResponse<List<GetAllFeatureResponse>> getAll() {
        List<Feature> features = featureService.getAll();

        List<GetAllFeatureResponse> getAllFeatureResponseList = FeatureMapper.INSTANCE.getAllResponseFromFeatureList(features);

        return new SuccessDataResponse<>(getAllFeatureResponseList, FeatureMessages.FEATURE_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdFeatureResponse> getById(@PathVariable Integer getById) {
        Feature feature = featureService.getById(getById);
        GetByIdFeatureResponse getByIdFeatureResponse = FeatureMapper.INSTANCE.getByIdResponseFromFeature(feature);

        return new SuccessDataResponse<>(getByIdFeatureResponse, FeatureMessages.FEATURE_LISTED);
    }
}
