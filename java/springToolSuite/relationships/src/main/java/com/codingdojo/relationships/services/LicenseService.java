package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	public static int licenseNumber;

	private final LicenseRepository licenseRepository;

	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

////READS all licenses//////////////////////////////////////////////////////////////////
	public List<License> allLicenses() {
		return licenseRepository.findAll();
	}
////CREATES a license////////////////////////////////////////////////////////////////////
	public License createLicense(License createLicense) {
		return licenseRepository.save(createLicense);
	}

////RETRIEVES a license by id/////////////////////////////////////////////////////////// 
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}

////GENERATES a license number//////////////////////////////////////////////////////////   
	public String generateLicenseNumber() {
		if (licenseRepository.findTopByOrderByNumberDesc().isEmpty()) {
			licenseNumber += 1;
			return Integer.toString(licenseNumber);
		}
		List<License> top = licenseRepository.findTopByOrderByNumberDesc();
		licenseNumber = 1 + (Integer.parseInt(top.get(0).getNumber()));
		return Integer.toString(licenseNumber);
	}
}
