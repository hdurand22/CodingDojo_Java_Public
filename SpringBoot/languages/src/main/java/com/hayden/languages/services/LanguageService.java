package com.hayden.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hayden.languages.models.Language;
import com.hayden.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    // adding the book repository as a dependency
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    // returns all the languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a language
    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    // retrieves a language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    // updates a language
    public Language updateLanguage(Language l) {
    	return languageRepository.save(l);
    }
    
    // deletes a language
    public Language deleteLanguage(Long id) {
    	Optional<Language> findLanguage = languageRepository.findById(id);
    	if (!findLanguage.isPresent()) {
    		return null;
    	}
    	else {
    		languageRepository.deleteById(id);
    		System.out.println("Language deleted!");
    		return null;
    	}
    }
}
