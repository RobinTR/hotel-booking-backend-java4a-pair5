package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "hotel_reviews")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class HotelReview extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Min(1)
    @Max(5)
    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "description")
    private String description;
}
