package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomTypeFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.AddRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature.UpdateRoomTypeFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeaturesByRoomTypeIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetByIdRoomTypeFeatureResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomTypeFeatureMapper {
    RoomTypeFeatureMapper INSTANCE = Mappers.getMapper(RoomTypeFeatureMapper.class);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "feature.id", source = "featureId")
    RoomTypeFeature roomTypeFeatureFromAddRequest(AddRoomTypeFeatureRequest addRoomTypeFeatureRequest);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "feature.id", source = "featureId")
    RoomTypeFeature roomTypeFeatureFromUpdateRequest(UpdateRoomTypeFeatureRequest updateRoomTypeFeatureRequest);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetByIdRoomTypeFeatureResponse getByIdResponseFromRoomTypeFeature(RoomTypeFeature roomTypeFeature);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetAllRoomTypeFeatureResponse getAllResponseMap(RoomTypeFeature roomTypeFeature);

    List<GetAllRoomTypeFeatureResponse> getAllResponseFromRoomTypeFeatureList(List<RoomTypeFeature> roomTypeFeature);

    @Mapping(target = "featureName", source = "feature.name")
    GetAllRoomTypeFeaturesByRoomTypeIdResponse GetAllRoomTypeFeaturesByRoomTypeIdResponseMap(RoomTypeFeature roomTypeFeature);

    List<GetAllRoomTypeFeaturesByRoomTypeIdResponse> GetAllRoomTypeFeaturesByRoomTypeIdResponseList(List<RoomTypeFeature> roomTypeFeatures);
}
