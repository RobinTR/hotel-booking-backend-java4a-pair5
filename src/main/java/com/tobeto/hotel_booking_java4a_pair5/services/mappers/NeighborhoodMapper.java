package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetAllNeighborhoodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.neighborhood.GetByIdNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface NeighborhoodMapper {

    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);

    @Mapping(target = "area.id", source = "areaId")
    Neighborhood neighborhoodFromAddRequest(AddNeighborhoodRequest request);

    @Mapping(target = "area.id", source = "areaId")
    Neighborhood neighborhoodFromUpdateRequest(UpdateNeighborhoodRequest request);

    @Mapping(target = "areaName", source = "area.name")
    GetAllNeighborhoodResponse getAllNeighborhoodResponseMap(Neighborhood neighborhood);

    List<GetAllNeighborhoodResponse> getAllNeighborhoodResponseList(List<Neighborhood> neighborhoods);

    @Mapping(target = "areaName", source = "area.name")
    GetByIdNeighborhoodResponse getByIdNeighborhoodResponse(Neighborhood neighborhood);


}
