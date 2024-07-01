package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class HotelSpecification {

    public static Specification<Hotel> hasHotelId(Integer hotelId) {
        return (root, query, cb) -> cb.equal(root.get("id"), hotelId);
    }

    public static Specification<Hotel> hasRoomCapacity(Integer roomCapacity) {
        return (root, query, cb) -> {
            if (roomCapacity != null) {
                Join<Object, Object> roomJoin = root.join("rooms");
                return cb.equal(roomJoin.get("roomType").get("capacity"), roomCapacity);
            }
            return cb.conjunction();
        };
    }

    public static Specification<Hotel> hasDateRange(LocalDate startDate, LocalDate endDate) {
        return (root, query, cb) -> {
            if (startDate != null && endDate != null) {
                Join<Object, Object> bookingJoin = root.join("bookings", JoinType.LEFT);
                return cb.and(
                        cb.lessThanOrEqualTo(bookingJoin.get("startDate"), endDate),
                        cb.greaterThanOrEqualTo(bookingJoin.get("endDate"), startDate)
                );
            }
            return cb.conjunction();
        };
    }

    public static Specification<Hotel> hasAvailableRooms() {
        return (root, query, cb) -> {
            Join<Object, Object> roomJoin = root.join("rooms", JoinType.LEFT);
            return cb.isTrue(roomJoin.get("isAvailable"));
        };
    }

    public static Specification<Hotel> hasLocation(String location) {
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
    public static Specification<Hotel> hasHotelFeatures() {
        return (root, query, cb) -> {
            Join<Object, Object> hotelFeaturesJoin = root.join("hotelFeatures", JoinType.LEFT);
            Join<Object, Object> featureJoin = hotelFeaturesJoin.join("features", JoinType.LEFT);
            return cb.isNotNull(featureJoin.get("id"));
        };
    }

    public static Specification<Hotel> hasHotelPrice(double minPrice,double maxPrice) {
        return (root, query, cb) -> {
            Join<Object, Object> roomJoin = root.join("rooms", JoinType.LEFT);

            return cb.between(roomJoin.get("cost"), minPrice, maxPrice);
        };
    }

}
