package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Autor;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 17.05.2015.
 */
public interface AutorService {
    
    void saveAutor(Autor autor);
    
    List<Autor> findAllAutors();

    Map<Integer, String> findAllAutorsMap();
    
    void deleteAutorByAutor_id(int autor_id);

}
