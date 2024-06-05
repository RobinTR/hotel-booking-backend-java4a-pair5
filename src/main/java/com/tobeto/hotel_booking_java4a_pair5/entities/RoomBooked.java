package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rooms_booked")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomBooked extends BaseEntity {
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "room_id")
    private int roomId;
}
