package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CountryService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/countries")
@AllArgsConstructor
public class CountriesController {
    private CountryService countryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddCountryRequest request) {
        return countryService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateCountryRequest request) {
        return countryService.update(request);
    }

}
