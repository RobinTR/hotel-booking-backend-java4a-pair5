package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;

import java.util.List;

public interface NeighborhoodService {

    Neighborhood add(AddNeighborhoodRequest request);

    Neighborhood update(UpdateNeighborhoodRequest request);

    String delete(Integer id);

    List<Neighborhood> getAll();

    Neighborhood getById(Integer id);
}
