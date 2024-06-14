package com.car.show.Service;

import com.car.show.Model.Car;
import com.car.show.Model.Image;
import com.car.show.Repository.CarRepository;
import com.car.show.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CarRepository carRepository;

    public void addCarImage(Long carId, String imageUrl) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        Image image = new Image(car, imageUrl);
        imageRepository.save(image);
    }
}
