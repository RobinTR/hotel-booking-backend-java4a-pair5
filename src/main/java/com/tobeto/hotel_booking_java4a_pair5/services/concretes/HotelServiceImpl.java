package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Address;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.AddressService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address.AddAddressRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.AddressMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.HotelRules;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final AddressService addressService;
    private final ManagerService managerService;
    private final HotelRules hotelRules;

    @Override
    public Hotel add(AddHotelRequest request) {
        Hotel hotel = HotelMapper.INSTANCE.hotelFromAddRequest(request);

        AddAddressRequest addAddressRequest = AddressMapper.INSTANCE.addRequestFromHotel(hotel);
        Address address = addressService.add(addAddressRequest);

        hotel.setAddress(address);
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
        Hotel hotel = hotelRules.findById(id);
        hotelRepository.delete(hotel);

        return HotelMessages.HOTEL_DELETED;
    }


    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Integer id) {
        return hotelRules.findById(id);
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
        return hotelRepository.findHotelWithAvailableRooms(hotelId);
    }

    @Override
    public Hotel searchByBookingDateHotelsResponse(LocalDate startDate, LocalDate endDate) {
        return hotelRepository.searchByBookingDateHotels(startDate, endDate);
    }

    @Override
    public List<Hotel> searchByRoomCapacityHotels(int person) {
        return hotelRepository.searchByRoomCapacityHotels(person);
    }

    @Override
    public List<Hotel> searchHotelByRoomWithFilters(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity) {
        Specification<Hotel> spec = hotelRules.createSpecification(hotelId, startDate, endDate, roomCapacity, null, null, null, null);
        List<Hotel> hotels = hotelRepository.findAll(spec);

        if (roomCapacity != null) {
            hotels = hotelRules.filterHotelsByRoomCapacity(hotels, roomCapacity);
        }

        if (startDate != null && endDate != null) {
            hotels = hotelRules.filterHotelsByDateRange(hotels, startDate, endDate);
            hotels = hotelRules.filterRoomsByAvailability(hotels, startDate, endDate);
        }

        return hotels;
    }

    @Override
    public List<Hotel> searchAllHotelsWithFilters(String location, LocalDate startDate, LocalDate endDate, Integer roomCapacity, Double minPrice, Double maxPrice, List<Integer> featureIds) {
        Specification<Hotel> spec = hotelRules.createSpecification(null, startDate, endDate, roomCapacity, location, minPrice, maxPrice, featureIds);
        List<Hotel> hotels = hotelRepository.findAll(spec);

        if (featureIds != null && !featureIds.isEmpty()) {
            hotels = hotelRules.filterHotelsByFeatures(hotels, featureIds);
        }

        if (roomCapacity != null) {
            hotels = hotelRules.filterHotelsByRoomCapacity(hotels, roomCapacity);
        }

        if (startDate != null && endDate != null) {
            hotels = hotelRules.filterHotelsByDateRange(hotels, startDate, endDate);
            hotels = hotelRules.filterRoomsByAvailability(hotels, startDate, endDate);
        }

        return hotels;
    }

    @Override
    public List<Hotel> searchHotelsByManager(Integer managerId) {
        Manager manager = managerService.getById(managerId);
        List<Hotel> hotels = new ArrayList<>();

        hotels.add(manager.getHotel());

        return hotels;
    }
}
