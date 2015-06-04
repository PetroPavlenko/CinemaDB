package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.CinemaDao;
import com.websystique.springmvc.model.Cinema;
import com.websystique.springmvc.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Petro on 18.05.2015.
 */
@Service("cinemaService")
@Transactional
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaDao dao;

    @Override
    public void saveCinema(Cinema cinema) {
        dao.saveCinema(cinema);
    }

    @Override
    public List<Cinema> findAllCinemas() {
        return dao.findAllCinemas();
    }

    @Override
    public void saveTicket(Ticket ticket) {
        dao.saveTicket(ticket);
    }

    @Override
    public Map<Integer, String> findAllCinemasMap() {
        return dao.findAllCinemasMap();
    }

    @Override
    public Map<Integer, String> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public void deleteCinemaByCinema_id(int cinema_id) {
        dao.deleteCinemaByCinema_id(cinema_id);
    }

    @Override
    public Map<Integer, String> findAllAddressMap() {
        return dao.findAllAddressMap();
    }

    @Override
    public Cinema findById(int cinema_id) {  return dao.findById(cinema_id);}

    @Override
    public String getAddressByAddress_id(int address_id) {
        return dao.getAddressByAddress_id(address_id);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return dao.findAllTickets();
    }

    @Override
    public String getCustomerName(int customer_id) {
        return dao.getCustomerName(customer_id);
    }

    @Override
    public void addTicket(Ticket ticket) {
        dao.addTicket(ticket);
    }
}
