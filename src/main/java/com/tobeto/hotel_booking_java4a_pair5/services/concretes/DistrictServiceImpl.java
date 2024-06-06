package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.repositories.DistrictRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.DistrictService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.DistrictMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetAllDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district.GetByIdDistrictResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.DistrictMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository districtRepository;

    @Override
    public Result add(AddDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromAddRequest(request);
        district = districtRepository.save(district);

        return new SuccessResult(DistrictMessages.DISTRICT_ADDED);
    }

    @Override
    public Result update(UpdateDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromUpdateRequest(request);
        district = districtRepository.save(district);

        return new SuccessResult(DistrictMessages.DISTRICT_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllDistrictResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdDistrictResponse> getById(Integer id) {
        return null;
    }
}
