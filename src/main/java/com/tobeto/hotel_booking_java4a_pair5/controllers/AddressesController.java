package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AddressService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.UpdateAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetAllAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetByIdAddressResponse;
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
    public Result add(@RequestBody @Valid AddAddressRequest request) {
        return addressService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateAddressRequest request) {
        return addressService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return addressService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllAddressResponse>> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdAddressResponse> getById(@PathVariable Integer getById) {
        return addressService.getById(getById);
    }

}
