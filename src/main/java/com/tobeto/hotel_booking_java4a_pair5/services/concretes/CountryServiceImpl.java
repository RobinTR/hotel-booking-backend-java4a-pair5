package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CountryRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CountryService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CountryMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CountryMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.CountryRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryRules countryRules;

    @Override
    public Country add(AddCountryRequest request) {
        Country country = CountryMapper.INSTANCE.countryFromAddRequest(request);
        country = countryRepository.save(country);

        return country;
    }

    @Override
    public Country update(UpdateCountryRequest request) {
        Country country = CountryMapper.INSTANCE.countryFromUpdateRequest(request);
        country = countryRepository.save(country);

        return country;
    }

    @Override
    public String delete(Integer id) {
        Country country = countryRules.findById(id);
        countryRepository.deleteById(country.getId());

        return CountryMessages.COUNTRY_DELETED;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Integer id) {
        return countryRules.findById(id);
    }
}
