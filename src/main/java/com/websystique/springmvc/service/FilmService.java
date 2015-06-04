package com.websystique.springmvc.service;

import java.lang.String;
import com.websystique.springmvc.model.Film;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 16.05.2015.
 */
public interface FilmService {

    Film findById(final int film_id);
    
    void saveFilm(Film Film);
    
    List<Film> findAllFilms();

    int Allin();

    int AllAt(final int film_id);

    Map<Integer, String> findAllFilmsMap();

    List<Integer> findAllFAutors(int film_Id);

    void deleteFilmByFilm_id(int film_id);

    void insertAutor_in_film(final int film_Id, final int autor_id);

    Map<Integer, String> AllCategoriesMap();

    List<Integer> getFilmCategories(int film_id);

    void deleteCategory_film(int film_id);

    void putCategory(int film_id,int category_id);

    double pributok(final int film_id);
    double pributok(final int cinema_id,final String start,final String ending);
    double pributok(final String start,final String ending);}