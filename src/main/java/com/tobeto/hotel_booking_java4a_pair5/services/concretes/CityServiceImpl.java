package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CityRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CityService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CityMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetAllCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city.GetByIdCityResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;

    @Override
    public Result add(AddCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromAddRequest(request);
        city = cityRepository.save(city);

        return new SuccessResult(CityMessages.CITY_ADDED);
    }

    @Override
    public Result update(UpdateCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromUpdateRequest(request);
        city = cityRepository.save(city);

        return new SuccessResult(CityMessages.CITY_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllCityResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdCityResponse> getById(Integer id) {
        return null;
    }
}
