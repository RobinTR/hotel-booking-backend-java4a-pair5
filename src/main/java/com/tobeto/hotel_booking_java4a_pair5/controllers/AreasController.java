package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
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
    public Result add(@RequestBody @Valid AddAreaRequest request) {
        return areaService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdateAreaRequest request) {
        return areaService.update(request);
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return areaService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllAreaResponse>> getAll() {
        return areaService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdAreaResponse> getById(@PathVariable Integer getById) {
        return areaService.getById(getById);
    }
}
