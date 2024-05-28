package com.car.show.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Double price;

    private String color;

    @Column(nullable = false)
    private String motorType;

    @Column(nullable = false)
    private Integer power;

    @Column(nullable = false)
    private Integer placeNumber;

    private Boolean status;

    @Column(nullable = false)
    private String type;

}
