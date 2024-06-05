package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "countries")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country extends BaseEntity {
    @Column(name = "binary_code")
    private String binaryCode;

    @Column(name = "triple_code")
    private String tripleCode;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_code")
    private String phoneCode;
}
