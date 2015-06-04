package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Petro on 17.05.2015.
 */
@Entity
@Table(name = "AUTOR")
public class Autor {
//    CREATE TABLE `autor` (
//            `autor_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
//    `first_name` varchar(45) NOT NULL,
//    `last_name` varchar(45) NOT NULL,
//    `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//    PRIMARY KEY (`autor_id`)
//    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autor_id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "last_name", nullable = false)
    private String last_name;

    public Autor(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Autor() {
    }

    public int getAutor_id() {
        return autor_id;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public java.lang.String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(java.lang.String first_name) {
        this.first_name = first_name;
    }

    public java.lang.String getLast_name() {
        return last_name;
    }

    public void setLast_name(java.lang.String last_name) {
        this.last_name = last_name;
    }

    @Override
    public java.lang.String toString() {
        return first_name + " " + last_name;
    }
}
