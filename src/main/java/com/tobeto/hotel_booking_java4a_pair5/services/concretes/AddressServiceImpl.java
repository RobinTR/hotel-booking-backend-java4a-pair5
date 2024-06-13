package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        address = addressRepository.save(address);

        return new SuccessResponse(AddressMessages.ADDRESS_ADDED);
    }

    @Override
    public Response update(UpdateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        address = addressRepository.save(address);

        return new SuccessResponse(AddressMessages.ADDRESS_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        //TODO: Refactor Exception and Message
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException(AddressMessages.ADDRESS_NOT_FOUND));
        addressRepository.deleteById(address.getId());

        return new SuccessResponse(AddressMessages.ADDRESS_DELETED);
    }

    @Override
    public DataResponse<List<GetAllAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAll();
        List<GetAllAddressResponse> response = AddressMapper.INSTANCE.getAllAddressResponseList(addresses);

        return new SuccessDataResponse<>(response, AddressMessages.ADDRESS_LISTED);
    }

    @Override
    public DataResponse<GetByIdAddressResponse> getById(Integer id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException(AddressMessages.ADDRESS_NOT_FOUND));
        GetByIdAddressResponse response = AddressMapper.INSTANCE.getByIdAddressResponse(address);

        return new SuccessDataResponse<>(response, AddressMessages.ADDRESS_LISTED);
    }
}
