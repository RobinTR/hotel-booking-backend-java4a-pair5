package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetByIdHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private HotelRepository hotelRepository;

    @Override
    public Response add(AddHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);
        hotel = hotelRepository.save(hotel);

        return new SuccessResponse(HotelMessages.HOTEL_ADDED);
    }

    @Override
    public Response update(UpdateHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromUpdateRequest(request);
        hotel = hotelRepository.save(hotel);

        return new SuccessResponse(HotelMessages.HOTEL_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelMessages.HOTEL_NOT_FOUND));
        hotelRepository.deleteById(hotel.getId());

        return new SuccessResponse(HotelMessages.HOTEL_DELETED);
    }


    @Override
    public DataResponse<List<GetAllHotelResponse>> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<GetAllHotelResponse> response = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResponse<GetByIdHotelResponse> getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelMessages.HOTEL_NOT_FOUND));
        GetByIdHotelResponse response = HotelMapper.INSTANCE.getByIdHotelResponse(hotel);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResponse<List<GetAllHotelResponse>> searchByHotelName(String name) {
        List<GetAllHotelResponse> response = hotelRepository.searchByHotelName(name);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResponse<List<GetAllHotelResponse>> searchByLocation(String name) {
        List<GetAllHotelResponse> response = hotelRepository.searchByLocation(name);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResponse<List<GetAllHotelResponse>> searchByStarRating(int star) {
        List<GetAllHotelResponse> response = hotelRepository.searchByStarRating(star);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResponse<List<GetAllHotelResponse>> searchByPrice(double minPrice, double maxPrice) {
        List<GetAllHotelResponse> response = hotelRepository.searchByPrice(minPrice, maxPrice);

        return new SuccessDataResponse<>(response, HotelMessages.HOTEL_LISTED);
    }
}
