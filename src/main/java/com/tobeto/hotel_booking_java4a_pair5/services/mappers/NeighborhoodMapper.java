package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.AddNeighborhoodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.neighborhood.UpdateNeighborhoodRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NeighborhoodMapper {

    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);

    @Mapping(target = "area.id", source = "areaId")
    Neighborhood neighborhoodFromAddRequest(AddNeighborhoodRequest request);

    @Mapping(target = "area.id", source = "areaId")
    Neighborhood neighborhoodFromUpdateRequest(UpdateNeighborhoodRequest request);
}
