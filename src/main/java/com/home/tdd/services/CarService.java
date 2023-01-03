package com.home.tdd.services;

import com.home.tdd.domain.Car;
import com.home.tdd.repo.CarRepository;

public class CarService {

    private CarRepository carRepository;

    public Car getCarDetails(String car){
        return null;
    }

    public CarService(CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }

}
