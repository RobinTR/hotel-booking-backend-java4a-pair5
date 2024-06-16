package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CountryService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CountryMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetAllCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetByIdCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CountryMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {
    private CountryService countryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddCountryRequest request) {
        countryService.add(request);

        return new SuccessResponse(CountryMessages.COUNTRY_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateCountryRequest request) {
        countryService.update(request);

        return new SuccessResponse(CountryMessages.COUNTRY_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        countryService.delete(id);

        return new SuccessResponse(CountryMessages.COUNTRY_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllCountryResponse>> getAll() {
        List<Country> countries = countryService.getAll();
        List<GetAllCountryResponse> getAllCountryResponseList = CountryMapper.INSTANCE.getAllCountryResponseListFromCountries(countries);

        return new SuccessDataResponse<>(getAllCountryResponseList, CountryMessages.COUNTRY_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdCountryResponse> getById(@PathVariable Integer getById) {
        Country country = countryService.getById(getById);
        GetByIdCountryResponse getByIdCountryResponse = CountryMapper.INSTANCE.getByIdCountryResponseFromCountry(country);

        return new SuccessDataResponse<>(getByIdCountryResponse, CountryMessages.COUNTRY_LISTED);
    }
}
