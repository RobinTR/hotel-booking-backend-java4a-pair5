package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
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
}
