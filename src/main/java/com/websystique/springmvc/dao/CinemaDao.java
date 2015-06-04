package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Cinema;
import com.websystique.springmvc.model.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 18.05.2015.
 */
public interface CinemaDao {
    void saveCinema(Cinema cinema);

    void saveTicket(Ticket ticket);

    List<Cinema> findAllCinemas();

    Map<Integer, String> findAllCinemasMap();

    Map<Integer, String> findAllUsers();

    Cinema findById(final int cinema_id);

    Map<Integer, String> findAllAddressMap();

    String getAddressByAddress_id(int address_id);

    void deleteCinemaByCinema_id(int cinema_id);

    List<Ticket> findAllTickets();

    public String getCustomerName(final int customer_id);

    void addTicket(Ticket ticket);
}
