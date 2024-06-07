package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
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
    public Result add(AddAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromAddRequest(request);
        area = areaRepository.save(area);

        return new SuccessResult(AreaMessages.AREA_ADDED);
    }

    @Override
    public Result update(UpdateAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromUpdateRequest(request);
        area = areaRepository.save(area);

        return new SuccessResult(AreaMessages.AREA_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        //TODO: Refactor Exception and Message
        Area area = areaRepository.findById(id).orElseThrow(() -> new RuntimeException(AreaMessages.AREA_NOT_FOUND));
        areaRepository.deleteById(area.getId());

        return new SuccessResult(AreaMessages.AREA_DELETED);

    }

    @Override
    public DataResult<List<GetAllAreaResponse>> getAll() {
        List<Area> areas = areaRepository.findAll();
        List<GetAllAreaResponse> response = AreaMapper.INSTANCE.getAllAreaResponseList(areas);

        return new SuccessDataResult<>(response, AreaMessages.AREA_LISTED);
    }

    @Override
    public DataResult<GetByIdAreaResponse> getById(Integer id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new RuntimeException(AreaMessages.AREA_NOT_FOUND));
        GetByIdAreaResponse response = AreaMapper.INSTANCE.getByIdAreaResponse(area);

        return new SuccessDataResult<>(response, AreaMessages.AREA_LISTED);
    }
}
