package com.car.show.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING, VALIDATED, REJECTED, ARCHIVED
    }
}
