package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelSpecification {
    public Specification<Hotel> hasHotelId(Integer hotelId) {
        return (root, query, cb) -> cb.equal(root.get("id"), hotelId);
    }

    public Specification<Hotel> hasRoomCapacity(Integer roomCapacity) {
        return (root, query, cb) -> {
            if (roomCapacity != null) {
                Join<Object, Object> roomJoin = root.join("rooms");
                return cb.equal(roomJoin.get("roomType").get("capacity"), roomCapacity);
            }
            return cb.conjunction();
        };
    }

    public Specification<Hotel> hasAvailableRooms(LocalDate startDate, LocalDate endDate) {
        return (root, query, cb) -> {
            Join<Object, Object> roomJoin = root.join("rooms", JoinType.LEFT);
            Join<Object, Object> roomBookedJoin = roomJoin.join("roomBooked", JoinType.LEFT);
            Join<Object, Object> bookingJoin = roomBookedJoin.join("booking", JoinType.LEFT);

            if (startDate != null && endDate != null) {
                Predicate isBookedWithinDateRange = cb.and(
                        cb.or(
                                cb.equal(bookingJoin.get("reservationStatus"), ReservationStatus.APPROVED),
                                cb.equal(bookingJoin.get("reservationStatus"), ReservationStatus.PENDING)
                        ),
                        cb.or(
                                cb.and(
                                        cb.lessThanOrEqualTo(bookingJoin.get("startDate"), endDate),
                                        cb.greaterThanOrEqualTo(bookingJoin.get("startDate"), startDate)
                                ),
                                cb.and(
                                        cb.lessThanOrEqualTo(bookingJoin.get("endDate"), endDate),
                                        cb.greaterThanOrEqualTo(bookingJoin.get("endDate"), startDate)
                                ),
                                cb.and(
                                        cb.lessThanOrEqualTo(bookingJoin.get("startDate"), startDate),
                                        cb.greaterThanOrEqualTo(bookingJoin.get("endDate"), endDate)
                                )
                        )
                );

                return cb.or(
                        cb.isNull(roomBookedJoin.get("booking")),
                        cb.not(isBookedWithinDateRange)
                );
            } else {
                return cb.isTrue(cb.literal(true));
            }
        };
    }

    public Specification<Hotel> hasLocation(String location) {
        return (root, query, cb) -> {
            String finalLocation = location.toUpperCase();
            Join<Hotel, Address> addressJoin = root.join("address");
            Join<Address, Neighborhood> neighborhoodJoin = addressJoin.join("neighborhood");
            Join<Neighborhood, Area> areaJoin = neighborhoodJoin.join("area");
            Join<Area, District> districtJoin = areaJoin.join("district");
            Join<District, City> cityJoin = districtJoin.join("city");
            Join<City, Country> countryJoin = cityJoin.join("country");

            return cb.or(
                    cb.like(cb.upper(neighborhoodJoin.get("name")), "%" + finalLocation + "%"),
                    cb.like(cb.upper(areaJoin.get("name")), "%" + finalLocation + "%"),
                    cb.like(cb.upper(districtJoin.get("name")), "%" + finalLocation + "%"),
                    cb.like(cb.upper(cityJoin.get("name")), "%" + finalLocation + "%"),
                    cb.like(cb.upper(countryJoin.get("name")), "%" + finalLocation + "%")
            );
        };
    }

    public Specification<Hotel> hasHotelFeatures(List<Integer> featureIds) {
        return (root, query, cb) -> {
            // Hotel ile HotelFeature ilişkisini join ediyoruz
            Join<Hotel, HotelFeature> hotelFeaturesJoin = root.join("hotelFeatures", JoinType.INNER);
            // HotelFeature ile Feature ilişkisini join ediyoruz
            Join<HotelFeature, Feature> featureJoin = hotelFeaturesJoin.join("feature", JoinType.INNER);
            // Feature id'leri üzerinden filtreleme yapıyoruz
            Predicate featurePredicate = featureJoin.get("id").in(featureIds);

            return featurePredicate;
        };
    }

    public Specification<Hotel> hasHotelPrice(double minPrice, double maxPrice) {
        return (root, query, cb) -> {
            Join<Object, Object> roomJoin = root.join("rooms", JoinType.LEFT);

            return cb.between(roomJoin.get("cost"), minPrice, maxPrice);
        };
    }
}
