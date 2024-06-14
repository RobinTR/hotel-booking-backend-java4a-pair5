package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CountryRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CountryService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.CountryMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.AddCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country.UpdateCountryRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetAllCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country.GetByIdCountryResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

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
        //TODO: Refactor Exception and Message
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException(CountryMessages.COUNTRY_NOT_FOUND));
        countryRepository.deleteById(country.getId());

        return CountryMessages.COUNTRY_DELETED;
    }

    @Override
    public List<Country> getAll() { return countryRepository.findAll(); }

    @Override
    public Country getById(Integer id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException(CountryMessages.COUNTRY_NOT_FOUND));

        return country;
    }
}
