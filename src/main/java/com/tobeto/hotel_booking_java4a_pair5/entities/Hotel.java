package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "hotels")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Size(min = 8, max = 128, message = "Hotel name must be between 8-128 characters.")
    @Column(name = "name")
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Size(max = 128, message = "Email must be maximum 128 characters.")
    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "description")
    private String description;

    @Column(name = "floor_count")
    private int floorCount;

    @Min(1)
    @Max(5)
    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "verified", columnDefinition = "boolean default false")
    private boolean verified;

    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "hotel")
    private List<Manager> managers;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @OneToMany(mappedBy = "hotel")
    private List<HotelReview> hotelReviews;

    @OneToMany(mappedBy = "hotel")
    private List<HotelImage> hotelImages;

    @OneToMany(mappedBy = "hotel")
    private List<HotelFeature> hotelFeatures;
}
