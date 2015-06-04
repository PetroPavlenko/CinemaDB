package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Cinema;
import com.websystique.springmvc.model.Ticket;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.jdbc.Work;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Petro on 18.05.2015.
 */
@Repository("CinemaDao")
public class CinemaDaoImpl extends AbstractDao implements CinemaDao {

    String ans;
    Map<Integer, String> ans2;
    Map<Integer, String> allCinemas;
    Map<Integer, String> allUsers;
    Cinema idCinema;


    public void saveCinema(Cinema cinema) {
        persist(cinema);
    }

    @Override
    public void saveTicket(Ticket ticket) {
        final Ticket t=ticket;
        Query query;

        if(!t.remark.isEmpty())
            query = getSession().createSQLQuery("INSERT INTO `customer_f` (`customer_id`, `film_id`, `cinema_id`, " +
                "`watching_date`, `pay`, `remark`) VALUES ('"+t.customer_id+"', '"+t.film_id+"', '"+t.cinema_id+"', '"+t.watching_date+"', '"+t.pay+"', '"+t.remark+"')");
        else
            query = getSession().createSQLQuery("INSERT INTO customer_f (customer_id, film_id, cinema_id, " +
                    "watching_date, pay) VALUES ('"+t.customer_id+"', '"+t.film_id+"', '"+t.cinema_id+"', '"+t.watching_date+"', '"+t.pay+"');");

        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Cinema> findAllCinemas() {
        Criteria criteria = getSession().createCriteria(Cinema.class);
        return (List<Cinema>) criteria.list();
    }

    private void findCinemasMap(Connection connection){
        Statement stmt = null;
        try {
            allCinemas = new TreeMap<Integer, String>();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cinema.cinema_id, cinema.name FROM cinema");
            while (rs.next()) {
                allCinemas.put(rs.getInt("cinema_id"),rs.getString("name"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
    }

    @Override
    public Map<Integer, String> findAllCinemasMap() {
        //SELECT cinema.cinema_id, cinema.name FROM cinema.cinema
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        findCinemasMap(connection);
                    }
                }
        );
        return allCinemas;
    }

    private void findAllUsersMap(Connection connection){
        Statement stmt = null;
        try {
            allUsers = new TreeMap<Integer, String>();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT customer_id, CONCAT(first_name,' ',last_name) as name FROM customers;");
            while (rs.next()) {
                allUsers.put(rs.getInt("customer_id"),rs.getString("name"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
    }

    @Override
    public Map<Integer, String> findAllUsers() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        findAllUsersMap(connection);
                    }
                }
        );
        return allUsers;
    }

    private void findCinemaById(Connection connection,int cinema_id){
        Statement stmt = null;
        idCinema = new Cinema();
        try {
            //            `cinema_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
//    `address_id` smallint(5) unsigned NOT NULL,
//    `name` varchar(20) NOT NULL,
//    `Area` int(10) unsigned DEFAULT '100',
//            `Rent_pay` decimal(10,2) unsigned NOT NULL DEFAULT '0.00',
//            `Comunal_pos` decimal(10,2) unsigned NOT NULL DEFAULT '10.00',
//            `Product` decimal(10,2) unsigned DEFAULT NULL,
//    `absolut_product` decimal(10,2) unsigned DEFAULT NULL,
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.cinema where cinema_id = "+cinema_id);
            if (rs.next()) {
                idCinema.setCinema_id(cinema_id);
                idCinema.setAddress_id(rs.getInt("address_id"));
                idCinema.setName(rs.getString("name"));
                idCinema.setArea(rs.getInt("Area"));
                idCinema.setRent_pay(rs.getBigDecimal("Rent_pay"));
                idCinema.setComunal_pos(rs.getBigDecimal("Comunal_pos"));
                idCinema.setProduct(rs.getBigDecimal("Comunal_pos"));
                idCinema.setAbsolut_product(rs.getBigDecimal("absolut_product"));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
    }

    @Override
    public Cinema findById(final int cinema_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        findCinemaById(connection, cinema_id);
                    }
                }
        );
        return idCinema;
    }

    @Override
    public Map<Integer, String> findAllAddressMap() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        final String query =
                "SELECT address.address_id,address.address, city.city FROM cinema.address  LEFT JOIN " +
                        "city ON `city`.`city_id` = `address`.`city_id`;";
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        findAllAddress(connection, query);
                    }
                }
        );
        return ans2;
    }

    private void findAllAddress(Connection connection, String query) {
        Statement stmt = null;
        ans2 = new TreeMap<Integer, String>();
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT address.address_id,address.address, city.city FROM cinema.address  LEFT JOIN " +
                    "city ON `city`.`city_id` = `address`.`city_id`");
            while (rs.next()) {
                int id = rs.getInt("address_id");//noerror
                String addr = rs.getString("address");
                String city = rs.getString("city");
                ans2.put(id, city + " " + addr);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
        //return ans2;
    }

    private void findAddress(Connection connection, String query, int address_id) {
        Statement stmt = null;
        ans = "";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT address.address_id,address.address,city.city,address.city_id,city.city_id FROM address " +
                    " JOIN city ON city.city_id = address.city_id WHERE address.address_id = " + address_id);
            if (rs.next()) {
                String address = rs.getString("address");
                //int id = rs.getInt(1);//error
                String city = rs.getString("city");
                ans = city + " " + address;
            } else {
                ans = "";
            }
            rs.close();
            //rs2.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
        //return ans;
    }

    @Override
    public String getAddressByAddress_id(final int address_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        final String query =
                "SELECT address.address_id,address.address, city.city FROM cinema.address " +
                        " LEFT JOIN city ON city.city_id = address.city_id WHERE address.address_id = " + address_id;
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        findAddress(connection, query, address_id);
                    }
                }
        );
        return ans;
    }
    
    public void deleteCinemaByCinema_id(int cinema_id) {
        Query query = getSession().createSQLQuery("delete from Cinema where cinema_id = :cinema_id");
        query.setString("cinema_id", cinema_id + "");
        query.executeUpdate();
    }

    List<Ticket> all;
    String CustomerName;

    private /*List<Integer>*/void doFindAll(Connection connection) {
        Statement stmt = null;
        all = new ArrayList<Ticket>();
        try {
            System.out.println("Creating statement...");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.customer_f;");
            //STEP 5: Extract data from result set
            while (rs.next()) {
                Ticket temp = new Ticket();
                temp.cinema_id = rs.getInt("cinema_id");
                temp.customer_id = rs.getInt("customer_id");
                temp.film_id = rs.getInt("film_id");
                temp.pay = rs.getBigDecimal("pay");
                temp.watching_date = rs.getString("watching_date");
                all.add(temp);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
        //return ans;
    }

    private void find_Customer(Connection connection,int customer_id){
        Statement stmt = null;

        CustomerName="";
        try {
            System.out.println("Creating statement...");
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.customers where customer_id = "+customer_id+";");
            //STEP 5: Extract data from result set
            if (rs.next()) {
                CustomerName=rs.getString("first_name")+" "+rs.getString("last_name");
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
        }
    }

    public String getCustomerName(final int customer_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        find_Customer(connection,customer_id);
                    }
                }
        );
        return CustomerName;
    }

    @Override
    public List<Ticket> findAllTickets() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        doFindAll(connection);
                    }
                }
        );
        return all;
    }

    @Override
    public void addTicket(Ticket ticket) {

    }
}
