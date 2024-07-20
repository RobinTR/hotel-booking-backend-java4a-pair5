package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.concretes.HotelSpecification;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelRules {
    private final HotelRepository hotelRepository;
    private final HotelSpecification hotelSpecification;

    public Hotel findById(Integer id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(HotelMessages.HOTEL_NOT_FOUND));
    }

    public Specification<Hotel> createSpecification(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity, String location, Double minPrice, Double maxPrice, List<Integer> featureIds) {
        Specification<Hotel> spec = Specification.where(null);
        if (hotelId != null) {
            spec = spec.and(hotelSpecification.hasHotelId(hotelId));
        }
        if (roomCapacity != null) {
            spec = spec.and(hotelSpecification.hasRoomCapacity(roomCapacity));
        }
        if (startDate != null && endDate != null) {
            spec = spec.and(hotelSpecification.hasAvailableRooms(startDate, endDate));
        }
        if (location != null && !location.isEmpty()) {
            spec = spec.and(hotelSpecification.hasLocation(location));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(hotelSpecification.hasHotelPrice(minPrice, maxPrice));
        }
        if (featureIds != null && !featureIds.isEmpty()) {
            spec = spec.and(hotelSpecification.hasHotelFeatures(featureIds));
        }

        return spec;
    }

    public List<Hotel> filterHotelsByFeatures(List<Hotel> hotels, List<Integer> featureIds) {
        List<Hotel> filteredHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            List<HotelFeature> filteredFeatures = hotel.getHotelFeatures().stream()
                    .filter(hf -> featureIds.contains(hf.getFeature().getId()))
                    .collect(Collectors.toList());
            if (!filteredFeatures.isEmpty()) {
                hotel.setHotelFeatures(filteredFeatures);
                filteredHotels.add(hotel);
            }
        }

        return filteredHotels;
    }

    public List<Hotel> filterHotelsByRoomCapacity(List<Hotel> hotels, Integer roomCapacity) {
        hotels.forEach(hotel -> {
            List<Room> filteredRooms = hotel.getRooms().stream()
                    .filter(room -> room.getRoomType().getCapacity() == roomCapacity)
                    .collect(Collectors.toList());
            hotel.setRooms(filteredRooms);
        });

        return hotels;
    }

    public List<Hotel> filterHotelsByDateRange(List<Hotel> hotels, LocalDate startDate, LocalDate endDate) {
        hotels.forEach(hotel -> {
            List<Booking> filteredBookings = hotel.getBookings().stream()
                    .filter(booking -> {
                        boolean isWithinDateRange = booking.getStartDate().isBefore(endDate.plusDays(1))
                                && booking.getEndDate().isAfter(startDate.minusDays(1));
                        return isWithinDateRange &&
                                (booking.getReservationStatus() == ReservationStatus.APPROVED || booking.getReservationStatus() == ReservationStatus.PENDING);
                    })
                    .collect(Collectors.toList());
            hotel.setBookings(filteredBookings);
        });

        return hotels;
    }

    public List<Hotel> filterRoomsByAvailability(List<Hotel> hotels, LocalDate startDate, LocalDate endDate) {
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

        return hotels;
    }
}
