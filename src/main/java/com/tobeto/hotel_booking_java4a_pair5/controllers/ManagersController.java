package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
@AllArgsConstructor
public class ManagersController {
    private ManagerService managerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddManagerRequest request) {
        return managerService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateManagerRequest request) {
        return managerService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return managerService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllManagerResponse>> getAll() {
        return managerService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdManagerResponse> getById(@PathVariable Integer getById) {
        return managerService.getById(getById);
    }
}
