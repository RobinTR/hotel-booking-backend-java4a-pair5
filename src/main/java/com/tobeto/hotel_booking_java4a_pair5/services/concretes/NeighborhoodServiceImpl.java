package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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
        return null;
    }

    @Override
    public DataResult<List<GetAllNeighborhoodResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdNeighborhoodResponse> getById(Integer id) {
        return null;
    }
}
