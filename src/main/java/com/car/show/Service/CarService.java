package com.car.show.Service;

import com.car.show.Model.Car;
import com.car.show.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;


    public List<Car> getCars(int page, int size) {
        return carRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public int getTotalCars() {
        return (int) carRepository.count();
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
