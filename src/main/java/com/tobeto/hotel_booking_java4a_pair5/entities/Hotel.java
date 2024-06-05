package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.print.Book;
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

    @ManyToOne
    @JoinColumn(name = "hotel_review_id")
    private HotelReview hotelReview;

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

    @OneToMany(mappedBy = "hotel")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "hotel")
    private List<Manager> managers;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
