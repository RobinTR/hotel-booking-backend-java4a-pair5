package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AreaService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AreaMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetAllAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AreaMapper;
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
        areaService.add(request);

        return new SuccessResponse(AreaMessages.AREA_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdateAreaRequest request) {
        areaService.update(request);

        return new SuccessResponse(AreaMessages.AREA_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        areaService.delete(id);

        return new SuccessResponse(AreaMessages.AREA_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllAreaResponse>> getAll() {
        List<Area> areas = areaService.getAll();
        List<GetAllAreaResponse> getAllAreaResponseList = AreaMapper.INSTANCE.getAllAreaResponseList(areas);

        return new SuccessDataResponse<>(getAllAreaResponseList, AreaMessages.AREA_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdAreaResponse> getById(@PathVariable Integer getById) {
        Area area = areaService.getById(getById);
        GetByIdAreaResponse getByIdAreaResponse = AreaMapper.INSTANCE.getByIdAreaResponse(area);

        return new SuccessDataResponse<>(getByIdAreaResponse, AreaMessages.AREA_LISTED);
    }
}
