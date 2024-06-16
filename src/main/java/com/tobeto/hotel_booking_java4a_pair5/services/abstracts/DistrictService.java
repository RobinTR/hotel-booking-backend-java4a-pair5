package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;


import com.tobeto.hotel_booking_java4a_pair5.entities.District;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.AddDistrictRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district.UpdateDistrictRequest;

import java.util.List;


public interface DistrictService {
    District add(AddDistrictRequest request);

    District update(UpdateDistrictRequest request);

    String delete(Integer id);

    List<District> getAll();

    District getById(Integer id);
}
