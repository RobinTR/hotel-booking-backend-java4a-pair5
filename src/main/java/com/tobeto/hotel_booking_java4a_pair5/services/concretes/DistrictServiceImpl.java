package com.tobeto.hotel_booking_java4a_pair5.services.concretes;


import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromAddRequest(request);
        district = districtRepository.save(district);

        return new SuccessResponse(DistrictMessages.DISTRICT_ADDED);
    }

    @Override
    public Response update(UpdateDistrictRequest request) {
        District district = DistrictMapper.INSTANCE.districtFromUpdateRequest(request);
        district = districtRepository.save(district);

        return new SuccessResponse(DistrictMessages.DISTRICT_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        //TODO: Refactor Exception and Message
        District district = districtRepository.findById(id).orElseThrow(() -> new RuntimeException(DistrictMessages.DISTRICT_NOT_FOUND));
        districtRepository.deleteById(district.getId());

        return new SuccessResponse(DistrictMessages.DISTRICT_DELETED);
    }

    @Override
    public DataResponse<List<GetAllDistrictResponse>> getAll() {
        List<District> districtes = districtRepository.findAll();
        List<GetAllDistrictResponse> response = DistrictMapper.INSTANCE.getAllDistrictResponseList(districtes);

        return new SuccessDataResponse<>(response, DistrictMessages.DISTRICT_LISTED);
    }

    @Override
    public DataResponse<GetByIdDistrictResponse> getById(Integer id) {
        District district = districtRepository.findById(id).orElseThrow(() -> new RuntimeException(DistrictMessages.DISTRICT_NOT_FOUND));
        GetByIdDistrictResponse response = DistrictMapper.INSTANCE.getByIdDistrictResponse(district);

        return new SuccessDataResponse<>(response, DistrictMessages.DISTRICT_LISTED);
    }
}
