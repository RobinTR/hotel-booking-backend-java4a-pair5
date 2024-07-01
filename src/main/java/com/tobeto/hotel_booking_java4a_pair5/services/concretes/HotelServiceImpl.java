package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public Hotel searchByBookingDateHotelsResponse(LocalDate startDate, LocalDate endDate) {
        Hotel hotel = hotelRepository.searchByBookingDateHotels(startDate, endDate);
        return hotel;
    }

    @Override
    public List<Hotel> searchByRoomCapacityHotels(int person) {
        List<Hotel> hotels = hotelRepository.searchByRoomCapacityHotels(person);
        return hotels;
    }

    @Override
    public List<Hotel> searchHotelByRoomWithFilters(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity) {
        Specification<Hotel> spec = Specification.where(HotelSpecification.hasHotelId(hotelId))
                .and(HotelSpecification.hasRoomCapacity(roomCapacity))
                .and(HotelSpecification.hasAvailableRooms(startDate, endDate));
        List<Hotel> hotels = hotelRepository.findAll(spec);

        // Filter rooms by capacity if roomCapacity is provided
        if (roomCapacity != null) {
            hotels.forEach(hotel -> {
                List<Room> filteredRooms = hotel.getRooms().stream()
                        .filter(room -> room.getRoomType().getCapacity() == roomCapacity)
                        .collect(Collectors.toList());
                hotel.setRooms(filteredRooms);
            });
        }

        // Filter bookings by date range and availability if startDate and endDate are provided
        if (startDate != null && endDate != null) {
            hotels.forEach(hotel -> {
                List<Booking> filteredBookings = hotel.getBookings().stream()
                        .filter(booking -> {
                            // Check if the booking is within the given date range
                            boolean isWithinDateRange = booking.getStartDate().isBefore(endDate.plusDays(1))
                                    && booking.getEndDate().isAfter(startDate.minusDays(1));

                            // Include booking if it meets the date criteria and has an approved or pending status
                            return isWithinDateRange &&
                                    (booking.getReservationStatus() == ReservationStatus.APPROVED || booking.getReservationStatus() == ReservationStatus.PENDING);
                        })
                        .collect(Collectors.toList());
                hotel.setBookings(filteredBookings);
            });
        }

        // After filtering bookings, ensure to filter out rooms that are booked within the given date range with APPROVED or PENDING status
        if (startDate != null && endDate != null) {
            hotels.forEach(hotel -> {
                List<Room> availableRooms = hotel.getRooms().stream()
                        .filter(room -> {
                            boolean isRoomAvailable = hotel.getBookings().stream()
                                    .noneMatch(booking -> {
                                        boolean isWithinDateRange = booking.getStartDate().isBefore(endDate.plusDays(1))
                                                && booking.getEndDate().isAfter(startDate.minusDays(1));
                                        return isWithinDateRange &&
                                                (booking.getReservationStatus() == ReservationStatus.APPROVED || booking.getReservationStatus() == ReservationStatus.PENDING) &&
                                                booking.getRoomBooked().stream()
                                                        .anyMatch(roomBooked -> roomBooked.getRoom().getId().equals(room.getId()));
                                    });
                            return isRoomAvailable;
                        })
                        .collect(Collectors.toList());
                hotel.setRooms(availableRooms);
            });
        }

        return hotels;
    }

    @Override
    public List<Hotel> searchAllHotelsWithFilters(String location, LocalDate startDate, LocalDate endDate, Integer roomCapacity,Double minPrice,Double maxPrice) {
        Specification<Hotel> spec = Specification.where(null);
        spec.and(HotelSpecification.hasRoomCapacity(roomCapacity))
                .and(HotelSpecification.hasLocation(location))
                .and(HotelSpecification.hasAvailableRooms(startDate, endDate))
                .and(HotelSpecification.hasHotelFeatures())
        ;
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(HotelSpecification.hasHotelPrice(minPrice, maxPrice));
        }
        List<Hotel> hotels = hotelRepository.findAll(spec);

        if (roomCapacity != null) {
            for (Hotel hotel : hotels) {
                List<Room> rooms = new ArrayList<>();

                for (Room room : hotel.getRooms()) {
                    if (room.getRoomType().getCapacity() == roomCapacity) {
                        rooms.add(room);
                    }
                }

                hotel.setRooms(rooms);
            }
        }

        // Filter bookings by date range and availability if startDate and endDate are provided
        if (startDate != null && endDate != null) {
            hotels.forEach(hotel -> {
                List<Booking> filteredBookings = hotel.getBookings().stream()
                        .filter(booking -> {
                            // Check if the booking is within the given date range
                            boolean isWithinDateRange = booking.getStartDate().isBefore(endDate.plusDays(1))
                                    && booking.getEndDate().isAfter(startDate.minusDays(1));

                            // Include booking if it meets the date criteria and has an approved or pending status
                            return isWithinDateRange &&
                                    (booking.getReservationStatus() == ReservationStatus.APPROVED || booking.getReservationStatus() == ReservationStatus.PENDING);
                        })
                        .collect(Collectors.toList());
                hotel.setBookings(filteredBookings);
            });
        }

        // After filtering bookings, ensure to filter out rooms that are booked within the given date range with APPROVED or PENDING status
        if (startDate != null && endDate != null) {
            hotels.forEach(hotel -> {
                List<Room> availableRooms = hotel.getRooms().stream()
                        .filter(room -> {
                            boolean isRoomAvailable = hotel.getBookings().stream()
                                    .noneMatch(booking -> {
                                        boolean isWithinDateRange = booking.getStartDate().isBefore(endDate.plusDays(1))
                                                && booking.getEndDate().isAfter(startDate.minusDays(1));
                                        return isWithinDateRange &&
                                                (booking.getReservationStatus() == ReservationStatus.APPROVED || booking.getReservationStatus() == ReservationStatus.PENDING) &&
                                                booking.getRoomBooked().stream()
                                                        .anyMatch(roomBooked -> roomBooked.getRoom().getId().equals(room.getId()));
                                    });
                            return isRoomAvailable;
                        })
                        .collect(Collectors.toList());
                hotel.setRooms(availableRooms);
            });
        }

        return hotels;
    }
}
