package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;

import java.util.List;

public interface AddressService {
    Address add(AddAddressRequest request);

    Address update(UpdateAddressRequest request);

    String delete(Integer id);

    List<Address> getAll();

    Address getById(Integer id);
}
