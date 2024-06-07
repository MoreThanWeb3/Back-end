package com.car.show.Model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
}
