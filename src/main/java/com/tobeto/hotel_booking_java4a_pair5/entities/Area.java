package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "areas")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Area extends BaseEntity {
    @Column(name = "district_id")
    private int districtId;

    @Column(name = "name")
    private String name;
}