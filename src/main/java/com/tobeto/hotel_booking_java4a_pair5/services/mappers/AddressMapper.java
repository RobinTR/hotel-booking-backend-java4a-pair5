package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetAllAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetByIdAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "country.id", source = "countryId")
    @Mapping(target = "district.id", source = "districtId")
    @Mapping(target = "city.id", source = "cityId")
    @Mapping(target = "area.id", source = "areaId")
    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Address addressFromAddRequest(AddAddressRequest request);

    @Mapping(target = "country.id", source = "countryId")
    @Mapping(target = "district.id", source = "districtId")
    @Mapping(target = "city.id", source = "cityId")
    @Mapping(target = "area.id", source = "areaId")
    @Mapping(target = "neighborhood.id", source = "neighborhoodId")
    Address addressFromUpdateRequest(UpdateAddressRequest request);

    @Mapping(target = "countryName", source = "country.name")
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "districtName", source = "district.name")
    @Mapping(target = "areaName", source = "area.name")
    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    GetAllAddressResponse getAllAddressResponseMap(Address address);

    List<GetAllAddressResponse> getAllAddressResponseList(List<Address> addresses);

    @Mapping(target = "countryName", source = "country.name")
    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "districtName", source = "district.name")
    @Mapping(target = "areaName", source = "area.name")
    @Mapping(target = "neighborhoodName", source = "neighborhood.name")
    GetByIdAddressResponse getByIdAddressResponse(Address address);
}
