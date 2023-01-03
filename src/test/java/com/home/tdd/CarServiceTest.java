package com.home.tdd;

import com.home.tdd.domain.Car;
import com.home.tdd.exceptions.CarNotFoundException;
import com.home.tdd.repo.CarRepository;
import com.home.tdd.services.CarService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest  {

    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Before
    public void setup () throws Exception {
        carService = new CarService(carRepository);

    }

    @Test
    public void getCarDetails_returnCarInfo() {

        given(carRepository.findByName("prius")).willReturn(new Car("hybrid", "prius"));
        Car car = carService.getCarDetails("prius");


        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");

    }

    @Test()
    public void getCarDetails_whenCarNotFound() throws Exception {
        given(carRepository.findByName("prius")).willReturn(null);
        carService.getCarDetails("prius");
    }
}
