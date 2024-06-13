package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromAddRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_ADDED);
    }

    @Override
    public Response update(UpdateNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromUpdateRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        Neighborhood neighborhood = neighborhoodRepository.findById(id).orElseThrow(() -> new RuntimeException(NeighborhoodMessages.NEIGHBORHOOD_NOT_FOUND));
        neighborhoodRepository.deleteById(neighborhood.getId());

        return new SuccessResponse(NeighborhoodMessages.NEIGHBORHOOD_DELETED);
    }

    @Override
    public DataResponse<List<GetAllNeighborhoodResponse>> getAll() {
        List<Neighborhood> neighborhoods = neighborhoodRepository.findAll();
        List<GetAllNeighborhoodResponse> response = NeighborhoodMapper.INSTANCE.getAllNeighborhoodResponseList(neighborhoods);

        return new SuccessDataResponse<>(response, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }

    @Override
    public DataResponse<GetByIdNeighborhoodResponse> getById(Integer id) {
        Neighborhood neighborhood = neighborhoodRepository.findById(id).orElseThrow(() -> new RuntimeException(NeighborhoodMessages.NEIGHBORHOOD_NOT_FOUND));
        GetByIdNeighborhoodResponse response = NeighborhoodMapper.INSTANCE.getByIdNeighborhoodResponse(neighborhood);

        return new SuccessDataResponse<>(response, NeighborhoodMessages.NEIGHBORHOOD_LISTED);
    }
}
