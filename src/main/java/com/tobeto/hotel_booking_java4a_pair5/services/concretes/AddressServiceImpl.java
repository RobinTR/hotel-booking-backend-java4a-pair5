package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AddressRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AddressService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AddressMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetAllAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetByIdAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    @Override
    public Result add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        address = addressRepository.save(address);

        return new SuccessResult(AddressMessages.ADDRESS_ADDED);
    }

    @Override
    public Result update(UpdateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        address = addressRepository.save(address);

        return new SuccessResult(AddressMessages.ADDRESS_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        //TODO: Refactor Exception and Message
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException(AddressMessages.ADDRESS_NOT_FOUND));
        addressRepository.deleteById(address.getId());

        return new SuccessResult(AddressMessages.ADDRESS_DELETED);
    }

    @Override
    public DataResult<List<GetAllAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<GetAllAddressResponse> response = AddressMapper.INSTANCE.getAllAddressResponseList(addresses);

        return new SuccessDataResult<>(response, AddressMessages.ADDRESS_LISTED);
    }

    @Override
    public DataResult<GetByIdAddressResponse> getById(Integer id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException(AddressMessages.ADDRESS_NOT_FOUND));
        GetByIdAddressResponse response = AddressMapper.INSTANCE.getByIdAddressResponse(address);

        return new SuccessDataResult<>(response, AddressMessages.ADDRESS_LISTED);
    }

    /*
    GetByIdCountryResponse countryResponse = countryService.getById(address.getCountry().getId()).getData();
    Country country = CountryMapper.INSTANCE.countryFromGetByIdResponse(countryResponse);

    GetByIdCityResponse getByIdCityResponse = cityService.getById(address.getCity().getId()).getData();
    City city = CityMapper.INSTANCE.cityFromGetByIdResponse(getByIdCityResponse);

    GetByIdDistrictResponse getByIdDistrictResponse = districtService.getById(address.getDistrict().getId()).getData();
    District district = DistrictMapper.INSTANCE.districtFromGetByIdResponse(getByIdDistrictResponse);

    GetByIdAreaResponse getByIdAreaResponse = areaService.getById(address.getArea().getId()).getData();
    Area area = AreaMapper.INSTANCE.areaFromGetByIdResponse(getByIdAreaResponse);

    GetByIdNeighborhoodResponse getByIdNeighborhoodResponse = neighborhoodService.getById(address.getNeighborhood().getId()).getData();
    Neighborhood neighborhood = NeighborhoodMapper.INSTANCE.neigborhoodFromGetByIdResponse(getByIdNeighborhoodResponse);
    */
}
