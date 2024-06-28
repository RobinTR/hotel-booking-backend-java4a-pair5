package com.tobeto.hotel_booking_java4a_pair5.services.mappers;


import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetAllDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetByIdDistrictResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District districtFromAddRequest(AddDistrictRequest request);

    District districtFromUpdateRequest(UpdateDistrictRequest request);

    GetAllDistrictResponse getAllDistrictResponseMap(District district);

    List<GetAllDistrictResponse> getAllDistrictResponseListFromDistricts(List<District> districts);

    GetByIdDistrictResponse getByIdDistrictResponseFromDistrict(District district);

    List<GetAllDistrictResponse> getAllDistrictResponseList(List<District> districts);
}
