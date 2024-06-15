package com.car.show.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonBackReference
    private Car car;

    @Column(columnDefinition = "TEXT")
    private String url;

    private Image() {}

    public Image(Car car, String url) {
        this.car = car;
        this.url = url;
    }

}
