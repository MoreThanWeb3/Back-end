package com.car.show.Repository;

import com.car.show.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository  extends JpaRepository<Image, Long> {
    List<Image> findByCarId(Long carId);
}
