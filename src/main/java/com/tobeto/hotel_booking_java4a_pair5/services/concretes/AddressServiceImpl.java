package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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
        return null;
    }

    @Override
    public DataResult<List<GetAllAddressResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdAddressResponse> getById(Integer id) {
        return null;
    }
}
