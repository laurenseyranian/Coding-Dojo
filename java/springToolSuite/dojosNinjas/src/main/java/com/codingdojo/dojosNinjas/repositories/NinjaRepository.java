package com.codingdojo.dojosNinjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosNinjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
////Retrieves ALL the Ninja's from the database
	List<Ninja> findAll();
////Retrieves one Dojo's by ID from the database
	Optional<Ninja> findById(Long id);
}
