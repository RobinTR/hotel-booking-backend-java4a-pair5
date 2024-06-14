package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.repositories.AreaRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AreaService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.AreaMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AreaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    @Override
    public Area add(AddAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromAddRequest(request);
        area = areaRepository.save(area);

        return area;
    }

    @Override
    public Area update(UpdateAreaRequest request) {
        Area area = AreaMapper.INSTANCE.areaFromUpdateRequest(request);
        area = areaRepository.save(area);

        return area;
    }

    @Override
    public String delete(Integer id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new BusinessException(AreaMessages.AREA_NOT_FOUND));
        areaRepository.deleteById(area.getId());

        return AreaMessages.AREA_DELETED;
    }

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area getById(Integer id) {
        Area area = areaRepository.findById(id).orElseThrow(() -> new BusinessException(AreaMessages.AREA_NOT_FOUND));

        return area;
    }
}
