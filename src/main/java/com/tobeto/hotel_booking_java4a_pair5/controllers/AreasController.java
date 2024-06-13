package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AreaService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetAllAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@AllArgsConstructor
public class AreasController {
    private AreaService areaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddAreaRequest request) {
        return areaService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateAreaRequest request) {
        return areaService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return areaService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllAreaResponse>> getAll() {
        return areaService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdAreaResponse> getById(@PathVariable Integer getById) {
        return areaService.getById(getById);
    }
}
