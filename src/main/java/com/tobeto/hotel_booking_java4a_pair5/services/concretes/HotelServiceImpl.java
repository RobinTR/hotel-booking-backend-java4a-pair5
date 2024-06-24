package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.GetAllHotelResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel add(AddHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);
        hotel = hotelRepository.save(hotel);

        return hotel;
    }

    @Override
    public Hotel update(UpdateHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromUpdateRequest(request);
        hotel = hotelRepository.save(hotel);

        return hotel;
    }

    @Override
    public String delete(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new BusinessException(HotelMessages.HOTEL_NOT_FOUND));
        hotelRepository.delete(hotel);

        return HotelMessages.HOTEL_DELETED;
    }


    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new BusinessException(HotelMessages.HOTEL_NOT_FOUND));

        return hotel;
    }

    @Override
    public List<Hotel> searchByHotelName(String name) {
        return hotelRepository.searchByHotelName(name);
    }

    @Override
    public List<Hotel> searchByLocation(String name) {
        return hotelRepository.searchByLocation(name);
    }

    @Override
    public List<Hotel> searchByStarRating(int star) {
        return hotelRepository.searchByStarRating(star);
    }

    @Override
    public List<Hotel> searchByPrice(double minPrice, double maxPrice) {
        return hotelRepository.searchByPrice(minPrice, maxPrice);
    }

    @Override
    public Hotel findHotelWithAvailableRooms(Integer hotelId) {
        Hotel hotel = hotelRepository.findHotelWithAvailableRooms(hotelId);

        return hotel;
    }
}
