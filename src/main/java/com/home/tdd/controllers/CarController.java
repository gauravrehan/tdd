package com.home.tdd.controllers;

import com.home.tdd.domain.Car;
import com.home.tdd.exceptions.CarNotFoundException;
import com.home.tdd.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name)
    {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex)
    {

    }
}
