package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetAllSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetByIdSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.SupportMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supports")
@AllArgsConstructor
public class SupportsController {
    private SupportService supportService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddSupportRequest request) {
        supportService.add(request);
        return new SuccessResponse(SupportMessages.SUPPORT_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateSupportRequest request) {
        supportService.update(request);
        return new SuccessResponse(SupportMessages.SUPPORT_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        supportService.delete(id);

        return new SuccessResponse(SupportMessages.SUPPORT_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllSupportResponse>> getAll() {
        List<Support> supports = supportService.getAll();
        List<GetAllSupportResponse> getAllSupportResponseList = SupportMapper.INSTANCE.getAllSupportResponseListFromSupports(supports);

        return new SuccessDataResponse<>(getAllSupportResponseList, SupportMessages.SUPPORT_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdSupportResponse> getById(@PathVariable Integer getById) {
        Support support = supportService.getById(getById);
        GetByIdSupportResponse getByIdSupportResponse = SupportMapper.INSTANCE.getByIdSupportResponseFromSupport(support);

        return new SuccessDataResponse<>(getByIdSupportResponse, SupportMessages.SUPPORT_LISTED);

    }
}
