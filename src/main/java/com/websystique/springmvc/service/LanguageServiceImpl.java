package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.LanguageDao;
import com.websystique.springmvc.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
@Service("languageService")
@Transactional
public class LanguageServiceImpl implements LanguageService {
    
    @Autowired
    private LanguageDao dao;
    
    public void saveLanguage(Language Language) {
        dao.saveLanguage(Language);
    }
    
    public List<Language> findAllLanguages() {
        return dao.findAllLanguages();
    }
    
    public void deleteLanguageByLanguage_id(int language_id) {
        dao.deleteLanguageByLanguage_id(language_id);
    }

    public Map<Integer, String> findAllLanguagesMap() {
        return dao.findAllLanguagesMap();
    }

    public String findById(int Language_id) {
        return dao.findById(Language_id);
    }
}