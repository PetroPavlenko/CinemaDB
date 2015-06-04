package com.websystique.springmvc.model;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by Petro on 21.05.2015.
 */
public class Ticket {
    public int cinema_id;
    public int film_id;
    public int customer_id;
    public String watching_date;
    public BigDecimal pay;
    public String remark;

    public int getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(int cinema_id) {
        this.cinema_id = cinema_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getWatching_date() {
        return watching_date;
    }

    public void setWatching_date(String watching_date) {
        this.watching_date = watching_date;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
