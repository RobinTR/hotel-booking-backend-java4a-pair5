package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cities")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class City extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "name")
    private String name;

    @Column(name = "plate_no")
    private String plateNo;

    @Column(name = "phone_code")
    private String phoneCode;

    @OneToMany(mappedBy = "city")
    private List<District> districts;
}
