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

    @Column(name = "cost")
    private double cost;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "smoke_friendly")
    private boolean smokeFriendly;

    @Column(name = "pet_friendly")
    private boolean petFriendly;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "food")
    private boolean food;

    @Column(name = "is_all_inclusive")
    private boolean isAllInclusive;

    @OneToMany(mappedBy = "type")
    private List<Room> rooms;
}
