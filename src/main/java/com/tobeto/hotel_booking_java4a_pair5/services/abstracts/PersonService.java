package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetAllPersonResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person.GetByIdPersonResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface PersonService extends UserDetailsService {
    Result delete(int id);

    DataResult<List<GetAllPersonResponse>> getAll();

    DataResult<GetByIdPersonResponse> getById(int id);
}
