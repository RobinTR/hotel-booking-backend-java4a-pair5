package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.repositories.NeighborhoodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.NeighborhoodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.NeighborhoodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.NeighborhoodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NeighborhoodServiceImpl implements NeighborhoodService {
    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public Result add(AddNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromAddRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return new SuccessResult(NeighborhoodMessages.NEIGHBORHOOD_ADDED);
    }

    @Override
    public Result update(UpdateNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromUpdateRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return new SuccessResult(NeighborhoodMessages.NEIGHBORHOOD_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        Neighborhood neighborhood = neighborhoodRepository.findById(id).orElseThrow(() -> new RuntimeException(NeighborhoodMessages.NEIGHBORHOOD_NOT_FOUND));
        neighborhoodRepository.deleteById(neighborhood.getId());

        return new SuccessResult(NeighborhoodMessages.NEIGHBORHOOD_DELETED);
    }

    @Override
    public DataResult<List<GetAllNeighborhoodResponse>> getAll() {
        List<Neighborhood> neighborhoods = neighborhoodRepository.findAll();
        List<GetAllNeighborhoodResponse> response = NeighborhoodMapper.INSTANCE.getAllNeighborhoodResponseList(neighborhoods);

        return new SuccessDataResult<>(response, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }

    @Override
    public DataResult<GetByIdNeighborhoodResponse> getById(Integer id) {
        Neighborhood neighborhood = neighborhoodRepository.findById(id).orElseThrow(() -> new RuntimeException(NeighborhoodMessages.NEIGHBORHOOD_NOT_FOUND));
        GetByIdNeighborhoodResponse response = NeighborhoodMapper.INSTANCE.getByIdNeighborhoodResponse(neighborhood);

        return new SuccessDataResult<>(response, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }
}
