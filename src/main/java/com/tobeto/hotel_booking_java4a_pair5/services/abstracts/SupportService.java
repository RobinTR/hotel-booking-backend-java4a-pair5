package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.*;

import java.util.List;

public interface SupportService {
    Result add(AddSupportRequest request);
    Result update(UpdateSupportRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllSupportResponse>> getAll();
    DataResult<GetByIdSupportResponse> getById(Integer id);
}
