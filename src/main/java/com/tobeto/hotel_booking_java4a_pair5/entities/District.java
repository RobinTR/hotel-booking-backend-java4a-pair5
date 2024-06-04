package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "districts")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class District extends BaseEntity {
    @Column(name = "city_id")
    private int cityId;

    @Column(name = "name")
    private String name;
}
