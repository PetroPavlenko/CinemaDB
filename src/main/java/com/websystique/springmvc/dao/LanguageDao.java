package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Language;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
public interface LanguageDao {
    void saveLanguage(Language employee);
    
    List<Language> findAllLanguages();

    Map<Integer,String> findAllLanguagesMap();

    String findById(int Language_id);
    
    void deleteLanguageByLanguage_id(int Language_id);
}
