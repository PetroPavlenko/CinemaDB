package com.websystique.springmvc.service;

import com.websystique.springmvc.model.Cinema;
import com.websystique.springmvc.model.Ticket;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 18.05.2015.
 */
public interface CinemaService {
    void saveCinema(Cinema cinema);

    List<Cinema> findAllCinemas();

    void saveTicket(Ticket ticket);

    Map<Integer, String> findAllCinemasMap();

    Map<Integer, String> findAllUsers();

    void deleteCinemaByCinema_id(int cinema_id);

    Map<Integer, String> findAllAddressMap();

    Cinema findById(final int cinema_id);

    String getAddressByAddress_id(int address_id);

    List<Ticket> findAllTickets();

    public String getCustomerName(final int customer_id);

    void addTicket(Ticket ticket);
}
