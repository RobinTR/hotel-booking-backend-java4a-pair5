package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "rooms")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private RoomType type;

    @Column(name = "number")
    private int number;

    @Column(name = "is_available")
    private boolean isAvailable;

    @OneToMany(mappedBy = "room")
    private List<RoomBooked> roomBooked;
}
