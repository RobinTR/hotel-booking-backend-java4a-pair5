package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "hotel_reviews")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HotelReview extends BaseEntity {
    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "description")
    private String description;
}
