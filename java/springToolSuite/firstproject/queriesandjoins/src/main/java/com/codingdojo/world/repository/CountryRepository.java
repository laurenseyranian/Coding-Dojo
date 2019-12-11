package com.codingdojo.world.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.world.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
	@Query("SELECT c,l FROM Country c Join c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	public List<Object[]> countriesSpeakingSlovene();
	
	@Query("SELECT c.name, COUNT(ci.id) AS num_cities FROM Country c JOIN c.cities ci GROUP BY c.id ORDER BY num_cities DESC")
	List<Object[]> findCountryCityCount();

}
