package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Language;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
public interface LanguageService {
    
    void saveLanguage(Language Language);
    
    List<Language> findAllLanguages();
    
    void deleteLanguageByLanguage_id(int language_id);

    Map<Integer, String> findAllLanguagesMap();

    String findById(int Language_id);
}