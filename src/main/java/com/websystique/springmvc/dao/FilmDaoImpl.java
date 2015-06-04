package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.Film;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.jdbc.Work;
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
 * Created by Petro on 16.05.2015.
 */
@Repository("filmDao")
public class FilmDaoImpl extends AbstractDao implements FilmDao {

    private List<Integer> ans;
    private List<String> strAns;
    private Film idFilm;
    private Map<Integer, String> allFilms;
    private Map<Integer, String> allCategories;
    private int out;
    private double outd;

    @Override
    public double pributok(final int film_id) {
        //SELECT (SELECT sum(pay)  From customer_f WHERE film_id = 7) - (SELECT central_rental_price From film WHERE film_id = 7) as pributok
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        outd = 0;
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT (SELECT sum(pay)  From customer_f WHERE film_id = " + film_id + ") " +
                                    "- (SELECT central_rental_price From film WHERE film_id = " + film_id + ") as 'out'");
                            if (rs.next()) {
                                outd = rs.getDouble("out");
                                if (AllAt(film_id) == 0) {
                                    ResultSet rs2 = stmt.executeQuery("SELECT central_rental_price as 'out' From film WHERE film_id = " + film_id);
                                    if (rs2.next())
                                        outd = -rs2.getDouble("out");
                                }
                            }
                            rs.close();
                            stmt.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (stmt != null)
                                    stmt.close();
                            } catch (SQLException se2) {
                            }
                        }
                    }
                }
        );
        return outd;
    }

    @Override
    public double pributok(final int cinema_id, final String start, final String ending) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        outd = 0;
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            stmt = connection.createStatement();
                            ResultSet rs;
                            if (cinema_id != 0)
                                rs = stmt.executeQuery("SELECT sum(pay) as 'out' FROM customer_f where watching_date" +
                                        " BETWEEN \"" + start + "\" AND \"" + ending + "\" AND cinema_id = " + cinema_id);
                            else
                                rs = stmt.executeQuery("SELECT sum(pay) AS 'out' FROM customer_f WHERE watching_date" +
                                        " BETWEEN \"" + start + "\" AND \"" + ending+"\"");

                            if (rs.next()) {
                                outd = rs.getDouble("out");
                            } else {
                                outd = 0;
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
                }
        );
        return outd;
    }

    @Override
    public double pributok(final String start, final String ending) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        outd = 0;
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT sum(pay) as 'out' FROM customer_f where watching_date" +
                                    " BETWEEN \"" + start + "\" AND \"" + ending + "\" ");
                            if (rs.next()) {
                                outd = rs.getDouble("out");
                            } else {
                                outd = 0;
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
                }
        );
        return outd;
    }

    public void saveFilm(Film filmer) {
        //INSERT INTO `cinema`.`film` (`film_id`, `title`, `length`, `description`, `tiket_price`, `central_rental_price`, `release_year`, `language_id`, `original_language_id`) VALUES ('5', '5', '5', '5', '5', '5', 1999, '2', '1');

        Query query = getSession().createSQLQuery(
                "INSERT INTO `cinema`.`film` (`film_id`, `title`, `length`, `description`, `tiket_price`, `central_rental_price`, `release_year`, `language_id`, `original_language_id`)" +
                        "VALUES ('" + filmer.getFilm_id() + "', '" + filmer.getTitle() + "', '" + filmer.getLength() + "', '" + filmer.getDescription() + "', '" +
                        filmer.getTiket_price() + "', '" + filmer.getCentral_rental_price() + "', " + filmer.getRelease_year() + ", '" + filmer.getLanguage_id() + "', '" +
                        +filmer.getOriginal_language_id() + "');");
        query.executeUpdate();
//        persist(filmer);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Film> findAllFilms() {
        Criteria criteria = getSession().createCriteria(Film.class);
        return (List<Film>) criteria.list();
    }

    @Override
    public int Allin() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out = 0;
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT count(*) as 'out' FROM customer_f");
                            if (rs.next()) {
                                out = rs.getInt("out");
                            } else {
                                out = 0;
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
                }
        );
        return out;
    }

    @Override
    public int AllAt(final int film_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out = 0;
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT count(*) as 'out' FROM customer_f where film_id = " + film_id);
                            if (rs.next()) {
                                out = rs.getInt("out");
                            } else {
                                out = 0;
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
                }
        );
        return out;
    }
    
    @Override
    public Map<Integer, String> findAllFilmsMap() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            allFilms = new TreeMap<Integer, String>();
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT film_id, title FROM film");
                            while (rs.next()) {
                                allFilms.put(rs.getInt("film_id"), rs.getString("title"));
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
                }
        );
        return allFilms;
    }

    @Override
    public Map<Integer, String> AllCategoriesMap() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            allCategories = new TreeMap<Integer, String>();
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT category_id as id,name FROM category");
                            while (rs.next()) {
                                allCategories.put(rs.getInt("id"), rs.getString("name"));
                            }
                            rs.close();
                            stmt.close();
                        } finally {
                            try {
                                if (stmt != null)
                                    stmt.close();
                            } catch (SQLException se2) {
                            }
                        }
                    }
                }
        );
        return allCategories;
    }

    @Override
    public List<Integer> getFilmCategories(final int film_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        Statement stmt = null;
                        try {
                            ans = new ArrayList<Integer>();
                            stmt = connection.createStatement();
                            ResultSet rs = stmt.executeQuery("SELECT category_id FROM film_category where film_id = " + film_id);
                            while (rs.next()) {
                                ans.add(rs.getInt("category_id"));
                            }
                            rs.close();
                            stmt.close();
                        } finally {
                            try {
                                if (stmt != null)
                                    stmt.close();
                            } catch (SQLException se2) {
                            }
                        }
                    }
                }
        );
        return ans;
    }

    @Override
    public void deleteCategory_film(int film_id) {
//        DELETE FROM `cinema`.`film_category` WHERE `film_id`='8' and`category_id`='2';
        Query query = getSession().createSQLQuery(
                "DELETE FROM film_category WHERE `film_id`=" + film_id);
        query.executeUpdate();
    }

    @Override
    public void putCategory(int film_id, int category_id) {
        Query query = getSession().createSQLQuery(
                "INSERT INTO film_category (`film_id`, `category_id`) VALUES ('" + film_id + "', '" + category_id + "');");
        query.executeUpdate();
    }
    
    private void findFilmsMap(Connection connection) {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT film_id, title FROM film");
            while (rs.next()) {
                allFilms.put(rs.getInt("film_id"), rs.getString("title"));
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
    
    private /*List<Integer>*/void doSomething(Connection connection, int film_Id) {
        Statement stmt = null;
        ans = new ArrayList<Integer>();
        try {
            System.out.println("Creating statement...");
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT film_autor.autor_id FROM film_autor where film_autor.film_id = " + film_Id);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                ans.add(rs.getInt("autor_id"));
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

    public List<Integer> findAllFAutors(final int film_Id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        doSomething(connection, film_Id);
                    }
                }
        );
        return ans;
    }

    private /*List<Integer>*/void doFilmId(Connection connection, int film_Id) {
        Statement stmt = null;
        idFilm = new Film();
        try {
            System.out.println("Creating statement...");
            stmt = connection.createStatement();
            //SELECT film.title FROM cinema.film where film_id=2
            ResultSet rs = stmt.executeQuery("SELECT * FROM cinema.film where film_id = " + film_Id);
            //STEP 5: Extract data from result set
            if (rs.next()) {

//                private String title;
//                private Integer length;
//                private String description;
//                private BigDecimal tiket_price;
//                private BigDecimal central_rental_price;
//                private Integer release_year;
//                private Integer language_id;
//                private Integer original_language_id;

                idFilm.setFilm_id(film_Id);
                idFilm.setTitle(rs.getString("title"));
                idFilm.setLanguage_id(rs.getInt("length"));
                idFilm.setDescription(rs.getString("description"));
                idFilm.setTiket_price(rs.getBigDecimal("tiket_price"));
                idFilm.setCentral_rental_price(rs.getBigDecimal("central_rental_price"));
                idFilm.setRelease_year(rs.getInt("release_year"));
                idFilm.setLanguage_id(rs.getInt("language_id"));
                idFilm.setOriginal_language_id(rs.getInt("original_language_id"));
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

    @Override
    public Film findById(final int film_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Connecting to database...");
        getSession().doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        doFilmId(connection, film_id);
                    }
                }
        );
        return idFilm;
    }

    public void insertAutor_in_film(final int film_Id, final int autor_id) {
        Query query = getSession().createSQLQuery("INSERT INTO `cinema`.`film_autor` (`autor_id`, `film_id`) VALUES ('" + autor_id + "', '" + film_Id + "');");
        query.executeUpdate();
    }

    public void deleteFilmByFilm_id(int film_id) {
        deleteCategory_film(film_id);
        Query query2 = getSession().createSQLQuery(" DELETE FROM `cinema`.`film_autor` WHERE `film_id`=" + film_id );
        //query2.setString("film_id", film_id + "");
        query2.executeUpdate();
        Query query = getSession().createSQLQuery("delete from Film where film_id = :film_id");
        query.setString("film_id", film_id + "");
        query.executeUpdate();
    }

}