package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;

    @Override
    public Result add(AddHotelRequest request) {
        return null;
    }

    @Override
    public Result update(UpdateHotelRequest request) {
        return null;
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllHotelResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdHotelResponse> getById(Integer id) {
        return null;
    }
}
