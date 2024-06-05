package com.tobeto.hotel_booking_java4a_pair5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "managers")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Manager extends Person {
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
