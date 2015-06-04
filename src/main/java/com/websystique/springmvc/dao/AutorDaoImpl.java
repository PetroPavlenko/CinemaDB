package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Autor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 17.05.2015.
 */
@Repository("AutorDao")
public class AutorDaoImpl extends AbstractDao implements AutorDao {
    
    public void saveAutor(Autor employee) {
        persist(employee);
    }

    @Override
    public Map<Integer, String> findAllAutorsMap() {
        Map<Integer, String> out = new LinkedHashMap<Integer, String>();
        List<Autor> results = findAllAutors();
        for (Autor aut : results) {
            out.put(aut.getAutor_id(), aut.getFirst_name() + " " + aut.getLast_name());
        }
        return out;
    }

    @SuppressWarnings("unchecked")
    public List<Autor> findAllAutors() {
        Criteria criteria = getSession().createCriteria(Autor.class);
        return (List<Autor>) criteria.list();
    }
    
    public void deleteAutorByAutor_id(int autor_id) {
        Query query = getSession().createSQLQuery("delete from Autor where autor_id = :autor_id");
        query.setString("autor_id", autor_id + "");
        query.executeUpdate();
    }
}
