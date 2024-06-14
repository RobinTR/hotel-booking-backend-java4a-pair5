package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Area;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.AddAreaRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.area.UpdateAreaRequest;

import java.util.List;

public interface AreaService {
    Area add(AddAreaRequest request);

    Area update(UpdateAreaRequest request);

    String delete(Integer id);

    List<Area> getAll();

    Area getById(Integer id);
}
