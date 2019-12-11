package com.codingdojo.queriesandjoins;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingdojo.queriesandjoins.models.City;
import com.codingdojo.queriesandjoins.models.Country;
import com.codingdojo.queriesandjoins.models.Language;
import com.codingdojo.queriesandjoins.repositories.CityRepository;
import com.codingdojo.queriesandjoins.repositories.CountryRepository;

@SpringBootTest
class QueriesandjoinsApplicationTests {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	CityRepository cityRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void questionOne() {
		List<Object[]> countries = countryRepository.countriesSpeakingSlovene();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " "+((Language)obj[1]).getLanguage() + " " + ((Language)obj[1]).getPercentage());
		}
	}
	
	@Test
	public void questionTwo() {
		List<Object[]> countries = countryRepository.findCountryCityCount();
		for (Object[] obj : countries) {
			System.out.println(obj[0] + " " + obj[1]);
		}
	}
	
	@Test
	public void questionThree() {
		List<Object[]> cities = cityRepository.findArgentinaCitiesInsideBuenosAires();
		for (Object[] obj : cities) {
			System.out.println(((City)obj[0]).getName() + " ");
		}
	}
	
	@Test
	public void questionFour() {
		List<Object[]> countries = countryRepository.findLanguagePercentage();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " ");
		}
	}
	
	@Test
	public void questionFive() {
		List<Object[]> countries = countryRepository.findCountrySurfaceAreaAndPopulation();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " ");
		}
	}
	
	@Test
	public void questionSix() {
		List<String> countries = countryRepository.findSurfaceArea();
		for (String obj : countries) {
			System.out.println(obj + " ");
		}
	}
	
	@Test
	public void questionSeven() {
		List<Object[]> cities = cityRepository.findArgentinaCitiesInsideBuenosAires();
		for (Object[] obj : cities) {
			System.out.println(((City)obj[0]).getName() + " ");
		}
	}
	
	@Test
	public void questionEight() {
		List<Object[]> countries = countryRepository.findNumberOfCountries();
		for (Object[] obj : countries) {
			System.out.println(((Country)obj[0]).getName() + " ");
		}
	}

}
