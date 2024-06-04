package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "hotels")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends BaseEntity {
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "hotel_review_id")
    private int hotelReviewId;

    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "description")
    private String description;

    @Column(name = "floor_count")
    private int floorCount;

    @Column(name = "room_capacity")
    private int roomCapacity;

    @Column(name = "star_rating")
    private int starRating;
}
