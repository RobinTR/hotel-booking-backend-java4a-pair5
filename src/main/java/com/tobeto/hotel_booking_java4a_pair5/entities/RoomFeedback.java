package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "room_feedbacks")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomFeedback extends BaseEntity {
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "is_answered")
    private boolean isAnswered;

    @Column(name = "star_rating")
    private int starRating;

    @Column(name = "description")
    private String description;

    @Column(name = "manager_feedback")
    private String managerFeedback;
}
