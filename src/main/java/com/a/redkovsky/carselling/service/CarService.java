package com.a.redkovsky.carselling.service;

import com.a.redkovsky.carselling.model.Car;
import com.a.redkovsky.carselling.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(Car car) {carRepository.save(car);}

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public void deleteCar(Long id){
         carRepository.deleteById(id);
    }
}
