package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.Language;
import com.websystique.springmvc.model.Language;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
@Repository("languageDao")
public class LanguageDaoImpl extends AbstractDao implements LanguageDao{

   // private JdbcTemplate jdbcTemplate;

    public void saveLanguage(Language language) {
        persist(language);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Language> findAllLanguages() {
        Criteria criteria = getSession().createCriteria(Language.class);
        return (List<Language>) criteria.list();
    }

    @Override
    public Map<Integer, String> findAllLanguagesMap() {
        Map<Integer,String> lang = new LinkedHashMap<Integer,String>();
        List<Language> languageList = findAllLanguages();
        for(Language  language:languageList){
            lang.put(language.getLanguage_id(), language.getName()+"");
        }
        return lang;
    }

    @Override
    public String findById(int Language_id) {
        Map<Integer, String> languageList = findAllLanguagesMap();
        //jdbcTemplate=getSession()
//        Query query = getSession().createSQLQuery("SELECT * FROM language where language_id = :Language_id");
//        List<Language> listContact = jdbcTemplate.query(query);
//        String sql = "SELECT * FROM language where language_id = " + Language_id;
//        List<Language> listContact = jdbcTemplate.query(sql, new RowMapper<Language>() {
//            @Override
//            public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Language aLanguage = new Language();
//               // aLanguage.setLanguage_id(rs.getInt("language_id"));
//                aLanguage.setName(rs.getString("name"));
//                return aLanguage;
//            }
//        });
        return languageList.get(Language_id);
    }
    
    public void deleteLanguageByLanguage_id(int language_id) {
        Query query = getSession().createSQLQuery("delete from Language where language_id = :language_id");
        query.setString("language_id", language_id + "");
        query.executeUpdate();
    }
}
