package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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
    public Result add(@RequestBody @Valid AddHotelRequest request) {
        return hotelService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateHotelRequest request) {
        return hotelService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return hotelService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllHotelResponse>> getAll() {
        return hotelService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdHotelResponse> getById(@PathVariable Integer getById) {
        return hotelService.getById(getById);
    }
}
