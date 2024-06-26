package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.AddFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.UpdateFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetAllFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.feature.GetByIdFeatureResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FeatureMapper {
    FeatureMapper INSTANCE = Mappers.getMapper(FeatureMapper.class);

    Feature featureFromAddRequest(AddFeatureRequest addFeatureRequest);

    Feature featureFromUpdateRequest(UpdateFeatureRequest updateFeatureRequest);

    GetByIdFeatureResponse getByIdResponseFromFeature(Feature feature);

    GetAllFeatureResponse getAllResponseMap(Feature feature);

    List<GetAllFeatureResponse> getAllResponseFromFeatureList(List<Feature> features);
}
