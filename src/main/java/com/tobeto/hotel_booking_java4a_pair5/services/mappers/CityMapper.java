package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetByIdCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(target = "country.id", source = "countryId")
    City cityFromAddRequest(AddCityRequest request);

    @Mapping(target = "country.id", source = "countryId")
    City cityFromUpdateRequest(UpdateCityRequest request);

    City cityFromGetByIdResponse(GetByIdCityResponse response);
}
