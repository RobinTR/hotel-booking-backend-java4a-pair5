package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cities")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class City extends BaseEntity {
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "plate_no")
    private String plateNo;

    @Column(name = "phone_code")
    private String phoneCode;
}
