package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;

import java.util.List;

public interface HotelService {
    Result add(AddHotelRequest request);

    Result update(UpdateHotelRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllHotelResponse>> getAll();

    DataResult<GetByIdHotelResponse> getById(Integer id);

    DataResult<List<GetAllHotelResponse>> searchByHotelName(String name);

    DataResult<List<GetAllHotelResponse>> searchByLocation(String name);

    DataResult<List<GetAllHotelResponse>> searchByStarRating(int star);

    DataResult<List<GetAllHotelResponse>> searchByPrice(double minPrice, double maxPrice);
}
