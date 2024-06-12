package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "supports")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Support extends BaseEntity {
    @Size(min = 2, max = 32, message = "First name must be between 2-32 characters.")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 32, message = "Last name must be between 2-32 characters.")
    @Column(name = "last_name")
    private String lastName;

    @Size(max = 128, message = "Email must be maximum 128 characters.")
    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

    @Column(name = "is_answered", columnDefinition = "boolean default false")
    private boolean isAnswered;

    @Column(name = "answer")
    private String answer;
}
