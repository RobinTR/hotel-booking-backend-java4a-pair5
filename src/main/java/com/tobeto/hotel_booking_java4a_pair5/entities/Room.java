package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "rooms")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {
    @Column(name = "number")
    private int number;

    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "type_id")
    private int typeId;

    @Column(name = "is_available")
    private boolean isAvailable;
}
