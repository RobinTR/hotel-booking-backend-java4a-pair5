package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.repositories.DistrictRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.DistrictService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.DistrictMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.DistrictMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.DistrictRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictRules districtRules;

    @Override
    public District add(AddDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromAddRequest(request);
        district = districtRepository.save(district);

        return district;
    }

    @Override
    public District update(UpdateDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromUpdateRequest(request);
        district = districtRepository.save(district);

        return district;
    }

    @Override
    public String delete(Integer id) {
        District district = districtRules.findById(id);
        districtRepository.deleteById(district.getId());

        return DistrictMessages.DISTRICT_DELETED;
    }

    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    @Override
    public District getById(Integer id) {
        return districtRules.findById(id);
    }
}
