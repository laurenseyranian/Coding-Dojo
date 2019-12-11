package com.codingdojo.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.queriesandjoins.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
//	1. What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language and language percentage. Your query should arrange the result by language percentage in descending order. (1)
	@Query("SELECT country,language FROM Country country Join country.languages language WHERE language.language = 'Slovene' ORDER BY language.percentage DESC")
	public List<Object[]> countriesSpeakingSlovene();
	
//	2. What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order. (3)
	@Query("SELECT country.name, COUNT(city.id) AS num_cities FROM Country country JOIN country.cities city GROUP BY country.id ORDER BY num_cities DESC")
	public List<Object[]> findCountryCityCount();
	
//	4. What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
	@Query("SELECT countries.name, languages.language, languages.percentage FROM Country JOIN languages ON countries.id=languages.country_id ORDER BY languages.percentage DESC")
	public List<Object[]> findLanguagePercentage();
	
//	5. What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
	@Query("SELECT countries.name FROM Country WHERE surface_area<501 and population>100000")
	public List<Object[]> findCountrySurfaceAreaAndPopulation();
	
//	6. What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
	@Query("SELECT c.name FROM Country c WHERE government_form='Constitutional Monarchy' AND capital>200 AND life_expectancy>75")
	public List<String> findSurfaceArea();
	
//	8. What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.
	@Query("SELECT region, count(id) as num_countries FROM Country GROUP BY region ORDER BY num_countries DESC")
	public List<Object[]> findNumberOfCountries();
}
