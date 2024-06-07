package com.tobeto.hotel_booking_java4a_pair5.services.mappers;


import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetAllAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AreaMapper {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    @Mapping(target = "district.id", source = "districtId")
    Area areaFromAddRequest(AddAreaRequest request);

    @Mapping(target = "district.id", source = "districtId")
    Area areaFromUpdateRequest(UpdateAreaRequest request);

    @Mapping(target = "districtName", source = "district.name")
    GetAllAreaResponse getAllAreaResponseMap(Area area);

    List<GetAllAreaResponse> getAllAreaResponseList(List<Area> areas);

    @Mapping(target = "districtName", source = "district.name")
    GetByIdAreaResponse getByIdAreaResponse(Area area);
}
