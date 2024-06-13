package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;

import java.util.List;

public interface HotelService {
    Response add(AddHotelRequest request);

    Response update(UpdateHotelRequest request);

    Response delete(Integer id);

    DataResponse<List<GetAllHotelResponse>> getAll();

    DataResponse<GetByIdHotelResponse> getById(Integer id);

    DataResponse<List<GetAllHotelResponse>> searchByHotelName(String name);

    DataResponse<List<GetAllHotelResponse>> searchByLocation(String name);

    DataResponse<List<GetAllHotelResponse>> searchByStarRating(int star);

    DataResponse<List<GetAllHotelResponse>> searchByPrice(double minPrice, double maxPrice);
}
