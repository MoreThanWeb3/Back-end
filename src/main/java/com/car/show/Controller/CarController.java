package com.car.show.Controller;

import com.car.show.Model.Car;
import com.car.show.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Car> cars = carService.getCars(page, size);
        int totalCars = carService.getTotalCars();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "cars " + page * size + "-" + ((page + 1) * size - 1) + "/" + totalCars);

        return ResponseEntity.ok().headers(headers).body(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        return car.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            Car updatedCar = car.get();
            updatedCar.setName(carDetails.getName());
            updatedCar.setDescription(carDetails.getDescription());
            updatedCar.setBrand(carDetails.getBrand());
            updatedCar.setModel(carDetails.getModel());
            updatedCar.setPrice(carDetails.getPrice());
            updatedCar.setColor(carDetails.getColor());
            updatedCar.setMotorType(carDetails.getMotorType());
            updatedCar.setPower(carDetails.getPower());
            updatedCar.setPlaceNumber(carDetails.getPlaceNumber());
            updatedCar.setStatus(carDetails.getStatus());
            updatedCar.setType(carDetails.getType());
            return ResponseEntity.ok(carService.saveCar(updatedCar));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
