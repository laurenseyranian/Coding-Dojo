package com.codingdojo.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.queriesandjoins.models.City;


public interface CityRepository extends CrudRepository<City, Long>{
//	3. What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order. (1)
	@Query("SELECT city.name, city.population FROM City JOIN Country WHERE countries.name='mexico' AND city.population>500000 ORDER BY city.population DESC")
	public List<Object[]> findMexicoPopulation();
	
//	7. What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.
	@Query("SELECT countries.name, cities.name as city, cities.district, cities.population FROM Country countries JOIN City cities WHERE countries.name='Argentina' AND cities.district='Buenos Aires' AND cities.population>500000")
	public List<Object[]> findArgentinaCitiesInsideBuenosAires();

}
