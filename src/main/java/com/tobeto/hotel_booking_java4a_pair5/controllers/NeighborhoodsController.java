package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/neighborhoods")
@AllArgsConstructor
public class NeighborhoodsController {
    private NeighborhoodService neighborhoodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddNeighborhoodRequest request) {
        return neighborhoodService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateNeighborhoodRequest request) {
        return neighborhoodService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return neighborhoodService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllNeighborhoodResponse>> getAll() {
        return neighborhoodService.getAll();
    }


    @GetMapping("/{getById}")
    public DataResult<GetByIdNeighborhoodResponse> getById(@PathVariable Integer getById) {
        return neighborhoodService.getById(getById);
    }
}

