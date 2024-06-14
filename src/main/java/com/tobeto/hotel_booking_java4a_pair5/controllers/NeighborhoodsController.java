package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.NeighborhoodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.NeighborhoodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.NeighborhoodMapper;
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
        neighborhoodService.add(request);

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_ADDED);
    }
    @PutMapping
    public Response update(@RequestBody @Valid UpdateNeighborhoodRequest request) {
        neighborhoodService.update(request);

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        neighborhoodService.delete(id);

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllNeighborhoodResponse>> getAll() {
        List<Neighborhood> neighborhoods = neighborhoodService.getAll();
        List<GetAllNeighborhoodResponse> getAllNeighborhoodsResponseList = NeighborhoodMapper.INSTANCE.getAllNeighborhoodResponseListFromNeighborhoods(neighborhoods);

        return new SuccessDataResponse<>(getAllNeighborhoodsResponseList, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdNeighborhoodResponse> getById(@PathVariable Integer getById) {
        Neighborhood neighborhood = neighborhoodService.getById(getById);
        GetByIdNeighborhoodResponse response = NeighborhoodMapper.INSTANCE.getByIdNeighborhoodResponseFromNeighborhood(neighborhood);

        return new SuccessDataResponse<>(response, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }
}

