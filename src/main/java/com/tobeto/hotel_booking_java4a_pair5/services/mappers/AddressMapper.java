package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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
}
