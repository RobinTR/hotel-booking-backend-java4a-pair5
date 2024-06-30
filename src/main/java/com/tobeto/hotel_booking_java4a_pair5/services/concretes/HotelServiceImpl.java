package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.repositories.HotelRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.HotelMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.AddHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotel.UpdateHotelRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.HotelMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    public List<Hotel> searchByRoomFilters(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity) {
        List<Hotel> hotels = hotelRepository.searchByRoomFilterss2(hotelId, startDate, endDate, roomCapacity);
        //Hotel hotel = hotelRepository.fetchHotelWithoutCollections(hotelId);

        /*if (hotel != null) {
            List<Booking> bookings = hotelRepository.fetchBookingsForHotel(hotelId, startDate, endDate);
            hotel.setBookings(bookings);

            List<Room> rooms = hotelRepository.fetchRoomsForHotel(hotelId, roomCapacity);
            hotel.setRooms(rooms);
        }*/

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

        return hotels;
    }

    @Override
    public List<Hotel> findAllHotelsWithFilterss(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity) {
        Specification<Hotel> spec = Specification.where(HotelSpecification.hasHotelId(hotelId))
                .and(HotelSpecification.hasRoomCapacity(roomCapacity))
                .and(HotelSpecification.hasDateRange(startDate, endDate))
                .and(HotelSpecification.hasAvailableRooms());
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
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByQueryParams(Specification<Hotel> spec) {
        return hotelRepository.findAll(spec);
    }

    @Override
    public List<Hotel> findHotelsByFilters(Integer hotelId, LocalDate startDate, LocalDate endDate, Integer roomCapacity) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Hotel> cq = cb.createQuery(Hotel.class);
        Root<Hotel> root = cq.from(Hotel.class);

        // Join HotelFeatures
        root.fetch("hotelFeatures", JoinType.LEFT);

        // Join Rooms and RoomFeatures
        Join<Hotel, Room> roomsJoin = root.join("rooms", JoinType.LEFT);
        roomsJoin.fetch("roomFeatures", JoinType.LEFT);

        List<Predicate> predicates = new ArrayList<>();

        if (startDate != null && endDate != null) {
            Join<Hotel, Booking> bookingJoin = root.join("bookings");
            predicates.add(cb.and(
                    cb.lessThanOrEqualTo(bookingJoin.get("startDate"), endDate),
                    cb.greaterThanOrEqualTo(bookingJoin.get("endDate"), startDate)
            ));
        }

        if (roomCapacity != null) {
            Join<Hotel, Room> roomJoin = root.join("rooms");
            predicates.add(cb.equal(roomJoin.get("roomType").get("capacity"), roomCapacity));
        }

        cq.select(root).distinct(true);
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Hotel> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Hotel> findAllHotelsWithFilters(LocalDate startDate, LocalDate endDate, Integer roomCapacity, String location) {
        Specification<Hotel> spec = Specification.where(null);

        if (location != null) {
            location = location.toUpperCase();
            String finalLocation = location;
            spec = spec.and((root, query, cb) -> {
                Join<Object, Object> addressJoin = root.join("address");
                Join<Object, Object> neighborhoodJoin = addressJoin.join("neighborhood");
                Join<Object, Object> areaJoin = neighborhoodJoin.join("area");
                Join<Object, Object> districtJoin = areaJoin.join("district");
                Join<Object, Object> cityJoin = districtJoin.join("city");
                Join<Object, Object> countryJoin = cityJoin.join("country");

                Predicate neighborhoodPredicate = cb.like(neighborhoodJoin.get("name"), "%" + finalLocation + "%");
                Predicate areaPredicate = cb.like(areaJoin.get("name"), "%" + finalLocation + "%");
                Predicate districtPredicate = cb.like(districtJoin.get("name"), "%" + finalLocation + "%");
                Predicate cityPredicate = cb.like(cityJoin.get("name"), "%" + finalLocation + "%");
                Predicate countryPredicate = cb.like(countryJoin.get("name"), "%" + finalLocation + "%");

                return cb.or(neighborhoodPredicate, areaPredicate, districtPredicate, cityPredicate, countryPredicate);
            });
        }

        if (startDate != null && endDate != null) {
            spec = spec.and((root, query, cb) -> {
                Join<Object, Object> bookingJoin = root.join("bookings");
                return cb.and(
                        cb.lessThanOrEqualTo(bookingJoin.get("startDate"), endDate),
                        cb.greaterThanOrEqualTo(bookingJoin.get("endDate"), startDate)
                );
            });
        }

        if (roomCapacity != null) {
            spec = spec.and((root, query, cb) -> {
                Join<Object, Object> roomJoin = root.join("rooms");
                return cb.equal(roomJoin.get("roomType").get("capacity"), roomCapacity);
            });
        }

        spec = spec.and((root, query, cb) -> {
            root.fetch("hotelFeatures", JoinType.LEFT);
            return cb.conjunction();
        });

        // Join RoomFeatures
        spec = spec.and((root, query, cb) -> {
            Join<Object, Object> roomsJoin = root.join("rooms");
            roomsJoin.fetch("roomFeatures", JoinType.LEFT);
            return cb.conjunction();
        });

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

        return hotels;
    }
}
