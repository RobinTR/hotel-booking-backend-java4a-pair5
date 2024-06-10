package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetAllUserResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.GetByIdUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    Result delete(int id);

    DataResult<List<GetAllUserResponse>> getAll();

    DataResult<GetByIdUserResponse> getById(int id);
}
