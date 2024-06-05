package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "neighborhoods")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "neighborhood")
    private List<Address> addresses;
}
