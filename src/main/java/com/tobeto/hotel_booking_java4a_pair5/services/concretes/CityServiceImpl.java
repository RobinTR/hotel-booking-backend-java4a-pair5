package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.City;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CityRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CityService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CityMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.AddCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city.UpdateCityRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CityMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.CityRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityRules cityRules;

    @Override
    public City add(AddCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromAddRequest(request);
        city = cityRepository.save(city);

        return city;
    }

    @Override
    public City update(UpdateCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromUpdateRequest(request);
        city = cityRepository.save(city);

        return city;
    }

    @Override
    public String delete(Integer id) {
        City city = cityRules.findById(id);
        cityRepository.deleteById(city.getId());

        return CityMessages.CITY_DELETED;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(Integer id) {
        return cityRules.findById(id);
    }
}
