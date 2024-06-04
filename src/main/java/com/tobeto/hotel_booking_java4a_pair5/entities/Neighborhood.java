package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "neighborhoods")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood extends BaseEntity {
    @Column(name = "area_id")
    private int areaId;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "name")
    private String name;

}
