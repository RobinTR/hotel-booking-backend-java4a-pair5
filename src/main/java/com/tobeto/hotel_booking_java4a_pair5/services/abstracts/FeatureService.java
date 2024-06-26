package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.AddFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.UpdateFeatureRequest;

import java.util.List;

public interface FeatureService {
    Feature add(AddFeatureRequest request);

    Feature update(UpdateFeatureRequest request);

    String delete(Integer id);

    List<Feature> getAll();

    Feature getById(Integer id);
}
