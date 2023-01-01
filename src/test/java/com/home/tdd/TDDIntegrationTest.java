package com.home.tdd;

import com.home.tdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TDDIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getCars_returnsCarDetails() throws Exception {
		//arrange

		//act
		ResponseEntity<Car> responseEntity = restTemplate.getForEntity("/cars/prius", Car.class);


		//assert
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(responseEntity.getBody().getName()).isEqualTo("prius");
		Assertions.assertThat(responseEntity.getBody().getType()).isEqualTo("hybrid");


	}

}
