package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CityService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CityMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetAllCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetByIdCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CityMapper;
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
        cityService.add(request);

        return new SuccessResponse(CityMessages.CITY_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateCityRequest request) {
        cityService.update(request);

        return new SuccessResponse(CityMessages.CITY_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        cityService.delete(id);

        return new SuccessResponse(CityMessages.CITY_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllCityResponse>> getAll() {
        List<City> cities = cityService.getAll();
        List<GetAllCityResponse> getAllCityResponseList = CityMapper.INSTANCE.getAllCityResponseList(cities);

        return new SuccessDataResponse<>(getAllCityResponseList, CityMessages.CITY_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdCityResponse> getById(@PathVariable Integer getById) {
        City city = cityService.getById(getById);
        GetByIdCityResponse getByIdCityResponse = CityMapper.INSTANCE.getByIdCityResponse(city);

        return new SuccessDataResponse<>(getByIdCityResponse, CityMessages.CITY_LISTED);
    }
}
