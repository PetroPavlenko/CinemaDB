package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Autor;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 17.05.2015.
 */
public interface AutorDao {
    
    void saveAutor(Autor autor);

    Map<Integer, String> findAllAutorsMap();

    List<Autor> findAllAutors();
    
    void deleteAutorByAutor_id(int autor_id);
}
