package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.AddRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature.UpdateRoomFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetAllRoomFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetAllRoomFeaturesByRoomIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetByIdRoomFeatureResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomFeatureMapper {
    RoomFeatureMapper INSTANCE = Mappers.getMapper(RoomFeatureMapper.class);

    @Mapping(target = "room.id", source = "roomId")
    @Mapping(target = "feature.id", source = "featureId")
    RoomFeature roomFeatureFromAddRequest(AddRoomFeatureRequest addRoomFeatureRequest);

    @Mapping(target = "room.id", source = "roomId")
    @Mapping(target = "feature.id", source = "featureId")
    RoomFeature roomFeatureFromUpdateRequest(UpdateRoomFeatureRequest updateRoomFeatureRequest);

    @Mapping(target = "roomId", source = "room.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetByIdRoomFeatureResponse getByIdResponseFromRoomFeature(RoomFeature roomFeature);

    @Mapping(target = "roomId", source = "room.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetAllRoomFeatureResponse getAllResponseMap(RoomFeature roomFeature);

    List<GetAllRoomFeatureResponse> getAllResponseFromRoomFeatureList(List<RoomFeature> roomFeature);

    @Mapping(target = "featureName", source = "feature.name")
    GetAllRoomFeaturesByRoomIdResponse GetAllRoomFeaturesByRoomIdResponseMap(RoomFeature roomFeature);

    List<GetAllRoomFeaturesByRoomIdResponse> GetAllRoomFeaturesByRoomIdResponseList(List<RoomFeature> roomFeatures);
}
