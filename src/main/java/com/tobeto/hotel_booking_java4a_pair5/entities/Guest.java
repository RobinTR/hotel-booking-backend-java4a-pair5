package com.tobeto.hotel_booking_java4a_pair5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "guests")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Guest extends Person {
    @Column(name = "payment_information_id")
    private int paymentInformationId;
}
