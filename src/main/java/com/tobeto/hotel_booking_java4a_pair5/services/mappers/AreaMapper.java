package com.tobeto.hotel_booking_java4a_pair5.services.mappers;


import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AreaMapper {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    @Mapping(target = "district.id", source = "districtId")
    Area areaFromAddRequest(AddAreaRequest request);

    @Mapping(target = "district.id", source = "districtId")
    Area areaFromUpdateRequest(UpdateAreaRequest request);

    Area areaFromGetByIdResponse(GetByIdAreaResponse response);
}
