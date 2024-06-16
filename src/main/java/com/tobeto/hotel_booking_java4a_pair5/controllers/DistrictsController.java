package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.DistrictService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.DistrictMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetAllDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetByIdDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.DistrictMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@AllArgsConstructor
public class DistrictsController {
    private DistrictService districtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddDistrictRequest request) {
        districtService.add(request);

        return new SuccessResponse(DistrictMessages.DISTRICT_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateDistrictRequest request) {
        districtService.update(request);

        return new SuccessResponse(DistrictMessages.DISTRICT_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        districtService.delete(id);

        return new SuccessResponse(DistrictMessages.DISTRICT_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllDistrictResponse>> getAll() {
        List<District> districts = districtService.getAll();
        List<GetAllDistrictResponse> response = DistrictMapper.INSTANCE.getAllDistrictResponseListFromDistricts(districts);

        return new SuccessDataResponse<>(response, DistrictMessages.DISTRICT_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdDistrictResponse> getById(@PathVariable Integer getById) {
        districtService.getById(getById);

        District district = districtService.getById(getById);
        GetByIdDistrictResponse response = DistrictMapper.INSTANCE.getByIdDistrictResponseFromDistrict(district);

        return new SuccessDataResponse<>(response, DistrictMessages.DISTRICT_LISTED);
    }
}
