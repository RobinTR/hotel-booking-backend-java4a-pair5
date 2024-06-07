package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
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
    public Result add(AddHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);
        hotel = hotelRepository.save(hotel);

        return new SuccessResult(HotelMessages.HOTEL_ADDED);
    }

    @Override
    public Result update(UpdateHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromUpdateRequest(request);
        hotel = hotelRepository.save(hotel);

        return new SuccessResult(HotelMessages.HOTEL_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelMessages.HOTEL_NOT_FOUND));
        hotelRepository.deleteById(hotel.getId());

        return new SuccessResult(HotelMessages.HOTEL_DELETED);
    }


    @Override
    public DataResult<List<GetAllHotelResponse>> getAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<GetAllHotelResponse> response = HotelMapper.INSTANCE.getAllHotelResponseList(hotels);

        return new SuccessDataResult<>(response, HotelMessages.HOTEL_LISTED);
    }

    @Override
    public DataResult<GetByIdHotelResponse> getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new RuntimeException(HotelMessages.HOTEL_NOT_FOUND));
        GetByIdHotelResponse response = HotelMapper.INSTANCE.getByIdHotelResponse(hotel);

        return new SuccessDataResult<>(response, HotelMessages.HOTEL_LISTED);
    }
}
