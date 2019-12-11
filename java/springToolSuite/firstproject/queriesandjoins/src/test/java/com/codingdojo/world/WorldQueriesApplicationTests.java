package com.codingdojo.world;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingdojo.world.model.City;
import com.codingdojo.world.model.Country;
import com.codingdojo.world.model.Language;

import com.codingdojo.world.repository.CountryRepository;

@SpringBootTest
class WorldQueriesApplicationTests {
	
	@Autowired
	CountryRepository countryRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testRepository() {
		List<Object[]> countries = countryRepository.countriesSpeakingSlovene();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " "+((Language)obj[1]).getLanguage() + " " + ((Language)obj[1]).getPercentage());
		}
	}
	
	@Test
	public void testCityCount() {
		List<Object[]> counts = countryRepository.findCountryCityCount();
		for (Object[] obj : counts) {
			System.out.println(obj[0] + " " + obj[1]);
		}
	}

}
