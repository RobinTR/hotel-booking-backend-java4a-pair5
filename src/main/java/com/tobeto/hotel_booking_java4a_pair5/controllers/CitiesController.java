package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CityService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetAllCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetByIdCityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CitiesController {
    private CityService cityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddCityRequest request) {
        return cityService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateCityRequest request) {
        return cityService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return cityService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllCityResponse>> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdCityResponse> getById(@PathVariable Integer getById) {
        return cityService.getById(getById);
    }
}
