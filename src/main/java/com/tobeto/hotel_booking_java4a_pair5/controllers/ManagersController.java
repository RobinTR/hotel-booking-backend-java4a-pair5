package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ManagerMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.ManagerMapper;
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
    public Response add(@RequestBody @Valid AddManagerRequest request) {
        managerService.add(request);

        return new SuccessResponse(ManagerMessages.MANAGER_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateManagerRequest request) {
        managerService.update(request);

        return new SuccessResponse(ManagerMessages.MANAGER_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        managerService.delete(id);

        return new SuccessResponse(ManagerMessages.MANAGER_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllManagerResponse>> getAll() {
        List<Manager> managers = managerService.getAll();
        List<GetAllManagerResponse> managerResponseList = ManagerMapper.INSTANCE.getAllManagerResponseList(managers);

        return new SuccessDataResponse<>(managerResponseList, ManagerMessages.MANAGER_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdManagerResponse> getById(@PathVariable Integer getById) {
        Manager manager = managerService.getById(getById);
        GetByIdManagerResponse getByIdManagerResponse = ManagerMapper.INSTANCE.getByIdManagerResponse(manager);

        return new SuccessDataResponse<>(getByIdManagerResponse, ManagerMessages.MANAGER_LISTED);

    }
}
