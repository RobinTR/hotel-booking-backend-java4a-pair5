package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CountryService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetAllCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetByIdCountryResponse;
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
    public Result add(@RequestBody @Valid AddCountryRequest request) {
        return countryService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateCountryRequest request) {
        return countryService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return countryService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllCountryResponse>> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdCountryResponse> getById(@PathVariable Integer getById) {
        return countryService.getById(getById);
    }
}
