package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.NeighborhoodService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/neighborhoods")
@AllArgsConstructor
public class NeighborhoodsController {
    private NeighborhoodService neighborhoodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddNeighborhoodRequest request) {
        return neighborhoodService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateNeighborhoodRequest request) {
        return neighborhoodService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return neighborhoodService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllNeighborhoodResponse>> getAll() {
        return neighborhoodService.getAll();
    }


    @GetMapping("/{getById}")
    public DataResponse<GetByIdNeighborhoodResponse> getById(@PathVariable Integer getById) {
        return neighborhoodService.getById(getById);
    }
}

