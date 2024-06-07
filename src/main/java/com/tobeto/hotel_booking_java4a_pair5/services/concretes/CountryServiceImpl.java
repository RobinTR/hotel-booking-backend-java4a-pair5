package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
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
    private CountryRepository countryRepository;

    @Override
    public Result add(AddCountryRequest request) {
        Country country = CountryMapper.INSTANCE.countryFromAddRequest(request);
        country = countryRepository.save(country);

        return new SuccessResult(CountryMessages.COUNTRY_ADDED);
    }

    @Override
    public Result update(UpdateCountryRequest request) {
        Country country = CountryMapper.INSTANCE.countryFromUpdateRequest(request);
        country = countryRepository.save(country);

        return new SuccessResult(CountryMessages.COUNTRY_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        //TODO: Refactor Exception and Message
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException(CountryMessages.COUNTRY_NOT_FOUND));
        countryRepository.deleteById(country.getId());

        return new SuccessResult(CountryMessages.COUNTRY_DELETED);
    }

    @Override
    public DataResult<List<GetAllCountryResponse>> getAll() {
        List<Country> countryes = countryRepository.findAll();
        List<GetAllCountryResponse> response = CountryMapper.INSTANCE.getAllCountryResponseList(countryes);

        return new SuccessDataResult<>(response, CountryMessages.COUNTRY_LISTED);
    }

    @Override
    public DataResult<GetByIdCountryResponse> getById(Integer id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new RuntimeException(CountryMessages.COUNTRY_NOT_FOUND));
        GetByIdCountryResponse response = CountryMapper.INSTANCE.getByIdCountryResponse(country);

        return new SuccessDataResult<>(response, CountryMessages.COUNTRY_LISTED);
    }
}
