package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetAllSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetByIdSupportResponse;
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
    public Result add(@RequestBody @Valid AddSupportRequest addSupportRequest) {
        return supportService.add(addSupportRequest);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateSupportRequest updateSupportRequest) {
        return supportService.update(updateSupportRequest);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return supportService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllSupportResponse>> getAll() {
        return supportService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdSupportResponse> getById(@PathVariable Integer getById) {
        return supportService.getById(getById);
    }
}
