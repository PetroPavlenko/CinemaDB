package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.AutorDao;
import com.websystique.springmvc.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 17.05.2015.
 */
@Service("autorService")
@Transactional
public class AutorServiceImpl implements AutorService {
    
    @Autowired
    private AutorDao dao;
    
    public void saveAutor(Autor autor) {
        dao.saveAutor(autor);
    }
    
    public List<Autor> findAllAutors() {
        return dao.findAllAutors();
    }

    @Override
    public Map<Integer, String> findAllAutorsMap() {
        return dao.findAllAutorsMap();
    }
    
    public void deleteAutorByAutor_id(int autor_id) {
        dao.deleteAutorByAutor_id(autor_id);
    }
}
