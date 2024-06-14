package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AddressService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AddressMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetAllAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetByIdAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AddressMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {
    private AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddAddressRequest request) {
        addressService.add(request);

        return new SuccessResponse(AddressMessages.ADDRESS_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateAddressRequest request) {
        addressService.update(request);

        return new SuccessResponse(AddressMessages.ADDRESS_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        addressService.delete(id);

        return new SuccessResponse(AddressMessages.ADDRESS_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllAddressResponse>> getAll() {
        List<Address> addresses = addressService.getAll();
        List<GetAllAddressResponse> getAllAddressResponseList = AddressMapper.INSTANCE.getAllAddressResponseList(addresses);

        return new SuccessDataResponse<>(getAllAddressResponseList, AddressMessages.ADDRESS_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdAddressResponse> getById(@PathVariable Integer getById) {
        Address address = addressService.getById(getById);
        GetByIdAddressResponse getByIdAddressResponse = AddressMapper.INSTANCE.getByIdAddressResponse(address);

        return new SuccessDataResponse<>(getByIdAddressResponse, AddressMessages.ADDRESS_LISTED);
    }
}
