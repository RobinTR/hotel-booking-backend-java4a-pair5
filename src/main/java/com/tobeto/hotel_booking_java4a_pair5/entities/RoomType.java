package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "room_types")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomType extends BaseEntity {
    @Size(min = 8, max = 128, message = "Room type name must be between 8-128 characters.")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "smoke_friendly", columnDefinition = "boolean default false")
    private boolean smokeFriendly;

    @Column(name = "pet_friendly", columnDefinition = "boolean default false")
    private boolean petFriendly;

    @Column(name = "wifi", columnDefinition = "boolean default false")
    private boolean wifi;

    @Column(name = "food", columnDefinition = "boolean default false")
    private boolean food;

    @Column(name = "is_all_inclusive", columnDefinition = "boolean default false")
    private boolean isAllInclusive;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;
}
