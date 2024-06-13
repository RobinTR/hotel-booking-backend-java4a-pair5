package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@AllArgsConstructor
public class HotelsController {
    private HotelService hotelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddHotelRequest request) {
        return hotelService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateHotelRequest request) {
        return hotelService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return hotelService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllHotelResponse>> getAll() {
        return hotelService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdHotelResponse> getById(@PathVariable Integer getById) {
        return hotelService.getById(getById);
    }

    @GetMapping("/searchByName")
    public DataResponse<List<GetAllHotelResponse>> searchByName(@RequestParam String name) {
        return hotelService.searchByHotelName(name);
    }

    @GetMapping("/searchByLocation")
    public DataResponse<List<GetAllHotelResponse>> searchByLocation(@RequestParam String location) {
        return hotelService.searchByLocation(location);
    }

    @GetMapping("/searchByStarRating")
    public DataResponse<List<GetAllHotelResponse>> searchByStarRating(@RequestParam int starRating) {
        return hotelService.searchByStarRating(starRating);
    }

    @GetMapping("/searchByPrice")
    public DataResponse<List<GetAllHotelResponse>> searchByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return hotelService.searchByPrice(minPrice, maxPrice);
    }
}
