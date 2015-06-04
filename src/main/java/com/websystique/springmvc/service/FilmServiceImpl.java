package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.FilmDao;
import java.lang.String;
import com.websystique.springmvc.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {
    
    @Autowired
    private FilmDao dao;
    
    @Override
    public Film findById(int film_id) {
        return dao.findById(film_id);
    }

    public void saveFilm(Film Film) {
        dao.saveFilm(Film);
    }

    public List<Integer> findAllFAutors(int film_Id){return dao.findAllFAutors(film_Id);}

    public List<Film> findAllFilms() {
        return dao.findAllFilms();
    }

    @Override
    public int Allin() {
        return dao.Allin();
    }

    @Override
    public int AllAt(int film_id) {
        return dao.AllAt(film_id);
    }

    @Override
    public Map<Integer, String> findAllFilmsMap() {
        return dao.findAllFilmsMap();
    }
    
    public void deleteFilmByFilm_id(int film_id) {
        dao.deleteFilmByFilm_id(film_id);
    }

    public void insertAutor_in_film(final int film_Id, final int autor_id){dao.insertAutor_in_film(film_Id, autor_id);}

    @Override
    public Map<Integer, String> AllCategoriesMap() {
        return dao.AllCategoriesMap();
    }

    @Override
    public List<Integer> getFilmCategories(int film_id) {
        return dao.getFilmCategories(film_id);
    }

    @Override
    public void deleteCategory_film(int film_id) {
        dao.deleteCategory_film(film_id);
    }

    @Override
    public void putCategory(int film_id, int category_id) {
        dao.putCategory(film_id,category_id);
    }

    @Override
    public double pributok(int film_id) {
        return dao.pributok(film_id);
    }

    @Override
    public double pributok(int cinema_id, String start, String ending) {
        return dao.pributok(cinema_id,start,ending);
    }

    @Override
    public double pributok(String start, String ending) {
        return dao.pributok(start,ending);
    }
}