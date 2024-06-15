package com.car.show.Service;

import com.car.show.Model.Car;
import com.car.show.Repository.CarRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars(int page, int size) {
        return carRepository.findAll(org.springframework.data.domain.PageRequest.of(page, size)).getContent();
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

    public List<Car> filterCars(String brand, String type, String color, Double maxPrice) {
        Specification<Car> spec = Specification.where(null);

        if (brand != null && !brand.isEmpty()) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("brand"), brand));
        }

        if (type != null && !type.isEmpty()) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("type"), type));
        }

        if (color != null && !color.isEmpty()) {
            spec = spec.and((root, query, builder) -> builder.equal(root.get("color"), color));
        }

        if (maxPrice != null) {
            spec = spec.and((root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }

        Sort sort = Sort.by(Sort.Direction.ASC, "price");

        return carRepository.findAll(spec, sort);
    }
    public Optional<Car> getCarByName(String name) {
        return carRepository.findByName(name);
    }

}
