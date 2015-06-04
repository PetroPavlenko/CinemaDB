package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Petro on 18.05.2015.
 */
@Entity
@Table(name = "CINEMA")
public class Cinema {
//    CREATE TABLE `cinema` (
//            `cinema_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
//    `address_id` smallint(5) unsigned NOT NULL,
//    `name` varchar(20) NOT NULL,
//    `Area` int(10) unsigned DEFAULT '100',
//            `Rent_pay` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
//            `Comunal_pos` decimal(10,2) unsigned NOT NULL DEFAULT '10.00',
//            `Product` decimal(10,2) unsigned DEFAULT NULL,
//    `absolut_product` decimal(10,2) unsigned DEFAULT NULL,
//    PRIMARY KEY (`cinema_id`),
//    KEY `fk_cinema_adress` (`address_id`),
//    CONSTRAINT `fk_cinema_adress` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
//    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cinema_id;

    @NotNull
    @Column(name = "address_id", nullable = false)
    int address_id;

    @Column(name = "Area", nullable = false)
    int Area;

    @Size(min = 1, max = 20)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "Rent_pay", nullable = false)
    private BigDecimal Rent_pay;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "Comunal_pos", nullable = false)
    private BigDecimal Comunal_pos;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "Product", nullable = false)
    private BigDecimal Product;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    @Column(name = "absolut_product", nullable = false)
    private BigDecimal absolut_product; //auto culc

    public Cinema() {
    }

    public Cinema(int address_id, String name, int area, BigDecimal rent_pay, BigDecimal comunal_pos, BigDecimal product) {
        this.address_id = address_id;
        this.name = name;
        Area = area;
        Rent_pay = rent_pay;
        Comunal_pos = comunal_pos;
        Product = product;
    }

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return Area;
    }

    public void setArea(int area) {
        Area = area;
    }

    public BigDecimal getRent_pay() {
        return Rent_pay;
    }

    public void setRent_pay(BigDecimal rent_pay) {
        Rent_pay = rent_pay;
    }

    public BigDecimal getComunal_pos() {
        return Comunal_pos;
    }

    public void setComunal_pos(BigDecimal comunal_pos) {
        Comunal_pos = comunal_pos;
    }

    public BigDecimal getProduct() {
        return Product;
    }

    public void setProduct(BigDecimal product) {
        Product = product;
    }

    public BigDecimal getAbsolut_product() {
        return absolut_product;
    }

    public void setAbsolut_product(BigDecimal absolut_product) {
        this.absolut_product = absolut_product;
    }
}
