package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AddressRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AddressService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AddressMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AddressMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.AddressRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressRules addressRules;

    @Override
    public Address add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        addressRules.checkNeighborhood(address, request.getNeighborhoodId());
        address = addressRepository.save(address);

        return address;
    }

    @Override
    public Address update(UpdateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        address = addressRepository.save(address);

        return address;
    }

    @Override
    public String delete(Integer id) {
        Address address = addressRules.findById(id);
        addressRepository.deleteById(address.getId());

        return AddressMessages.ADDRESS_DELETED;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Integer id) {
        return addressRules.findById(id);
    }
}
