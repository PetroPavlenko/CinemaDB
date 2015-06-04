package com.websystique.springmvc.model;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petro on 17.05.2015.
 */
public class FilmReg {
    public int film_id;
    public String title;
    public Integer length;
    public String description;
    public BigDecimal tiket_price;
    public BigDecimal central_rental_price;
    public Integer release_year;
    public Integer language_id;
    public Integer original_language_id;
    public List<Integer> Film_autor_id;
    public List<Integer> Category_id;

    public FilmReg() {
        Category_id = new ArrayList<Integer>();
        Category_id.add(0);
        Film_autor_id = new ArrayList<Integer>();
        Film_autor_id.add(0);
    }

    public Film Film() {
        return new Film(film_id, title, length, description, tiket_price, central_rental_price, release_year, language_id, original_language_id);
    }

    public List<Integer> getFilm_autor_id() {
        return Film_autor_id;
    }

    public void setFilm_autor_id(List<Integer> film_autor_id) {
        Film_autor_id = film_autor_id;
    }

    public List<Integer> getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(List<Integer> category_id) {
        Category_id = category_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTiket_price() {
        return tiket_price;
    }

    public void setTiket_price(BigDecimal tiket_price) {
        this.tiket_price = tiket_price;
    }

    public BigDecimal getCentral_rental_price() {
        return central_rental_price;
    }

    public void setCentral_rental_price(BigDecimal central_rental_price) {
        this.central_rental_price = central_rental_price;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public Integer getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Integer language_id) {
        this.language_id = language_id;
    }

    public Integer getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(Integer original_language_id) {
        this.original_language_id = original_language_id;
    }

}
