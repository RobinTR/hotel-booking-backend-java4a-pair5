package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.DistrictService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetAllDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetByIdDistrictResponse;
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
        return districtService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateDistrictRequest request) {
        return districtService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return districtService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllDistrictResponse>> getAll() {
        return districtService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdDistrictResponse> getById(@PathVariable Integer getById) {
        return districtService.getById(getById);
    }
}
