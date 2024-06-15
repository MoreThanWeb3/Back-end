package com.car.show.Repository;

import com.car.show.Model.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAll(Specification<Car> spec, Sort sort);

    Optional<Car> findByName(String name);
}
