package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "addresses")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "city_id")
    private int cityId;

    @Column(name = "district_id")
    private int districtId;

    @Column(name = "area_id")
    private int areaId;

    @Column(name = "full_address")
    private String fullAddress;
}
