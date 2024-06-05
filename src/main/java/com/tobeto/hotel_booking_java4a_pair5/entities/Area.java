package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "areas")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Area extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "area")
    private List<Address> addresses;

    @OneToMany(mappedBy = "area")
    private List<Neighborhood> neighborhoods;
}
