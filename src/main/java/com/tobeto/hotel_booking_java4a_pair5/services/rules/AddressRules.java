package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.entities.Neighborhood;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AddressRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AddressMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressRules {
    private final AddressRepository addressRepository;

    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AddressMessages.ADDRESS_NOT_FOUND));
    }

    public void checkNeighborhood(Address address, Integer neighborhoodId) {
        if (neighborhoodId == null) {
            Neighborhood neighborhood = null;
            address.setNeighborhood(neighborhood);
        }
    }
}
