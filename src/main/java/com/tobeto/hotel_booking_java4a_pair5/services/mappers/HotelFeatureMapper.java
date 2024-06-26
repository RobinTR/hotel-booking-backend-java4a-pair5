package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.entities.HotelFeature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.AddHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature.UpdateHotelFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetAllFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetByIdFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature.GetAllHotelFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature.GetAllHotelFeaturesByHotelId;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature.GetByIdHotelFeatureResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface HotelFeatureMapper {
    HotelFeatureMapper INSTANCE = Mappers.getMapper(HotelFeatureMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "feature.id", source = "featureId")
    HotelFeature hotelFeatureFromAddRequest(AddHotelFeatureRequest addHotelFeatureRequest);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "feature.id", source = "featureId")
    HotelFeature hotelFeatureFromUpdateRequest(UpdateHotelFeatureRequest updateHotelFeatureRequest);

    @Mapping(target = "hotelId", source = "hotel.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetByIdHotelFeatureResponse getByIdResponseFromHotelFeature(HotelFeature hotelFeature);

    @Mapping(target = "hotelId", source = "hotel.id")
    @Mapping(target = "featureId", source = "feature.id")
    GetAllHotelFeatureResponse getAllResponseMap(HotelFeature hotelFeature);

    List<GetAllHotelFeatureResponse> getAllResponseFromHotelFeatureList(List<HotelFeature> hotelFeatures);

    @Mapping(target = "featureName", source = "feature.name")
    GetAllHotelFeaturesByHotelId getAllHotelFeaturesByHotelIdMap(HotelFeature hotelFeature);

    List<GetAllHotelFeaturesByHotelId> getAllHotelFeaturesByHotelIdFromHotelFeatureList(List<HotelFeature> hotelFeatures);
}
