package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
// -------------------------------------------------------------------------------------------------
// CREATES one language
// -------------------------------------------------------------------------------------------------
	public Language createLangauge(Language createLanguage) {
		return languageRepository.save(createLanguage);
	}
// -------------------------------------------------------------------------------------------------
// UPDATES one language
// -------------------------------------------------------------------------------------------------
	public Language updateLanguage(Language updateLanguage) {
		return languageRepository.save(updateLanguage);
	}
//-------------------------------------------------------------------------------------------------
// UPDATES one language by id
//------------------------------------------------------------------------------------------------- 
	// UPDATES one language by id
	public Language updateLanguage(Long id, String creator, String name, double version) {
		Language updateLanguage = this.findLanguage(id);
		updateLanguage.setCreator(creator);
		updateLanguage.setName(name);
		updateLanguage.setVersion(version);
		languageRepository.save(updateLanguage);
		return updateLanguage;
	}
//-------------------------------------------------------------------------------------------------
// DELETE one language by ID
//------------------------------------------------------------------------------------------------- 
	public void deleteLanguage(Long id) {
		Language deleteLanguage = this.findLanguage(id);
		languageRepository.delete(deleteLanguage);
	}
//-------------------------------------------------------------------------------------------------
// FIND one language by id
//-------------------------------------------------------------------------------------------------  
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
}
