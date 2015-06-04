package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Petro on 17.05.2015.
 */

@Table(name = "film_autor")
public class film_autor {

    @NotNull
    @Column(name = "autor_id", nullable = false)
    private int autor_id;

    @NotNull
    @Column(name = "film_id", nullable = false)
    private int  film_id;

    public film_autor() {
    }

    public film_autor(int autor_id, int film_id) {
        this.autor_id = autor_id;
        this.film_id = film_id;
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
