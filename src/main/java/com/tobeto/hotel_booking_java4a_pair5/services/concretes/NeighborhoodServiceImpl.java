package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.repositories.NeighborhoodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.NeighborhoodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.NeighborhoodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.NeighborhoodMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.NeighborhoodRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeighborhoodServiceImpl implements NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;
    private final NeighborhoodRules neighborhoodRules;

    @Override
    public Neighborhood add(AddNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromAddRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return neighborhood;
    }

    @Override
    public Neighborhood update(UpdateNeighborhoodRequest request) {
        Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neighborhoodFromUpdateRequest(request);
        neighborhood = neighborhoodRepository.save(neighborhood);

        return neighborhood;
    }

    @Override
    public String delete(Integer id) {
        Neighborhood neighborhood = neighborhoodRules.findById(id);
        neighborhoodRepository.deleteById(neighborhood.getId());

        return NeighborhoodMessages.NEIGHBORHOOD_DELETED;
    }

    @Override
    public List<Neighborhood> getAll() {
        return neighborhoodRepository.findAll();
    }

    @Override
    public Neighborhood getById(Integer id) {
        return neighborhoodRules.findById(id);
    }
}
