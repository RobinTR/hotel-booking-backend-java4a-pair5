package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AreaRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AreaService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AreaMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetAllAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area.GetByIdAreaResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AreaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    @Override
    public Response add(AddAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromAddRequest(request);
        area = areaRepository.save(area);

        return new SuccessResponse(AreaMessages.AREA_ADDED);
    }

    @Override
    public Response update(UpdateAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromUpdateRequest(request);
        area = areaRepository.save(area);

        return new SuccessResponse(AreaMessages.AREA_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        //TODO: Refactor Exception and Message
        Area area = areaRepository.findById(id).orElseThrow(() -> new RuntimeException(AreaMessages.AREA_NOT_FOUND));
        areaRepository.deleteById(area.getId());

        return new SuccessResponse(AreaMessages.AREA_DELETED);

    }

    @Override
    public DataResponse<List<GetAllAreaResponse>> getAll() {
        List<Area> areas = areaRepository.findAll();
        List<GetAllAreaResponse> response = AreaMapper.INSTANCE.getAllAreaResponseList(areas);

        return new SuccessDataResponse<>(response, AreaMessages.AREA_LISTED);
    }

    @Override
    public DataResponse<GetByIdAreaResponse> getById(Integer id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new RuntimeException(AreaMessages.AREA_NOT_FOUND));
        GetByIdAreaResponse response = AreaMapper.INSTANCE.getByIdAreaResponse(area);

        return new SuccessDataResponse<>(response, AreaMessages.AREA_LISTED);
    }
}
