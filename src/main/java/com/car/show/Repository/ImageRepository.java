package com.car.show.Repository;

import com.car.show.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
