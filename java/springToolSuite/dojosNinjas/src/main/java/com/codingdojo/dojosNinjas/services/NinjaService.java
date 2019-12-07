package com.codingdojo.dojosNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

////READS all the Ninja's//////////////////////////////////////////////////////////////////
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

////CREATES one Ninja//////////////////////////////////////////////////////////////////////
	public Ninja createNinja(Ninja createNinja) {
		return ninjaRepository.save(createNinja);
	}

////RETRIEVES one Ninja by ID////////////////////////////////////////////////////////////// 
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
////DELETES one Ninja by ID////////////////////////////////////////////////////////////////
	public void deleteNinja(Long id) {
		Ninja deleteNinja= this.findNinja(id);
	 	ninjaRepository.delete(deleteNinja);
	 }
}


