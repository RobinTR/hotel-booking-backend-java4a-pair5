package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Feature;
import com.tobeto.hotel_booking_java4a_pair5.repositories.FeatureRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.FeatureService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.FeatureMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.AddFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.feature.UpdateFeatureRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.FeatureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {
    private final FeatureRepository featureRepository;

    @Override
    public Feature add(AddFeatureRequest request) {
        Feature feature = FeatureMapper.INSTANCE.featureFromAddRequest(request);
        feature = featureRepository.save(feature);

        return feature;
    }

    @Override
    public Feature update(UpdateFeatureRequest request) {
        Feature feature = FeatureMapper.INSTANCE.featureFromUpdateRequest(request);
        feature = featureRepository.save(feature);

        return feature;
    }

    @Override
    public String delete(Integer id) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new BusinessException(FeatureMessages.FEATURE_NOT_FOUND));
        featureRepository.delete(feature);

        return FeatureMessages.FEATURE_DELETED;
    }

    @Override
    public List<Feature> getAll() {
        return featureRepository.findAll();
    }

    @Override
    public Feature getById(Integer id) {
        Feature feature = featureRepository.findById(id).orElseThrow(() -> new BusinessException(FeatureMessages.FEATURE_NOT_FOUND));

        return feature;
    }
}
