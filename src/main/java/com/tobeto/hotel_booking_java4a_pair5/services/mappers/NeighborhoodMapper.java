package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NeighborhoodMapper {
    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);


    Neighborhood neighborhoodFromAddRequest(AddNeighborhoodRequest request);


    Neighborhood neighborhoodFromUpdateRequest(UpdateNeighborhoodRequest request);


    GetAllNeighborhoodResponse getAllNeighborhoodResponseMap(Neighborhood neighborhood);

    List<GetAllNeighborhoodResponse> getAllNeighborhoodResponseListFromNeighborhoods(List<Neighborhood> neighborhoods);


    GetByIdNeighborhoodResponse getByIdNeighborhoodResponseFromNeighborhood(Neighborhood neighborhood);

    List<GetAllNeighborhoodResponse> getAllNeighborhoodResponseList(List<Neighborhood> neighborhoods);

}
