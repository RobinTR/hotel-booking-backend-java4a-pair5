package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
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
        hotelService.add(request);

        return new SuccessResponse(HotelMessages.HOTEL_ADDED);

    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateHotelRequest request) {
        hotelService.update(request);

        return new SuccessResponse(HotelMessages.HOTEL_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        hotelService.delete(id);

        return new SuccessResponse(HotelMessages.HOTEL_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllHotelResponse>> getAll() {
        List<Hotel> hotels = hotelService.getAll();
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdHotelResponse> getById(@PathVariable Integer getById) {
        Hotel hotel = hotelService.getById(getById);
        GetByIdHotelResponse getByIdHotelResponse = HotelMapper.INSTANCE.getByIdHotelResponse(hotel);

        return new SuccessDataResponse<>(getByIdHotelResponse, HotelMessages.HOTEL_LISTED);
    }

    @GetMapping("/searchByName")
    public DataResponse<List<GetAllHotelResponse>> searchByName(@RequestParam String name) {
        List<Hotel> hotels = hotelService.searchByHotelName(name);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);

    }

    @GetMapping("/searchByLocation")
    public DataResponse<List<GetAllHotelResponse>> searchByLocation(@RequestParam String location) {
        List<Hotel> hotels = hotelService.searchByLocation(location);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);

    }

    @GetMapping("/searchByStarRating")
    public DataResponse<List<GetAllHotelResponse>> searchByStarRating(@RequestParam int starRating) {
        List<Hotel> hotels = hotelService.searchByStarRating(starRating);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);

    }

    @GetMapping("/searchByPrice")
    public DataResponse<List<GetAllHotelResponse>> searchByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Hotel> hotels = hotelService.searchByPrice(minPrice, maxPrice);
        List<GetAllHotelResponse> hotelResponseList = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(hotelResponseList, HotelMessages.HOTEL_LISTED);

    }
}
