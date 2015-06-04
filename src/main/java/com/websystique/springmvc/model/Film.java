package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Petro on 16.05.2015.
 */

@Entity
@Table(name = "FILM")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "length", nullable = false)
    private Integer length;

    @Column(name = "description")
    private String description;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "tiket_price", nullable = false)
    private BigDecimal tiket_price;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "central_rental_price", nullable = false)
    private BigDecimal central_rental_price;

    @NotNull
    //@DateTimeFormat(pattern="yyyy")
    @Column(name = "release_year", nullable = false)
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private Integer release_year;

    @NotNull
    @Column(name = "language_id", nullable = false)
    private Integer language_id;

    @NotNull
    @Column(name = "original_language_id", nullable = false)
    private Integer original_language_id;

//    private Integer Film_autor_id;
//
//    public Integer getFilm_autor_id() {
//        return Film_autor_id;
//    }
//
//    public void delete_Film_autor_id(){Film_autor_id = null;}
//
//    public void setFilm_autor_id(Integer film_autor_id) {
//        Film_autor_id = film_autor_id;
//    }

    public Film() {
    }

    public Film(Integer film_id, String title, Integer length, String description, BigDecimal tiket_price, BigDecimal central_rental_price, Integer release_year, Integer language_id, Integer original_language_id) {
        this.film_id = film_id;
        this.title = title;
        this.length = length;
        this.description = description;
        this.tiket_price = tiket_price;
        this.central_rental_price = central_rental_price;
        this.release_year = release_year;
        this.language_id = language_id;
        this.original_language_id = original_language_id;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
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
