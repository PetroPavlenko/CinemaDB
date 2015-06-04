package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.*;
import com.websystique.springmvc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/")
public class AppController {
    //    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    FilmService serviceFilms;
    @Autowired
    LanguageService serviceLanguages;
    @Autowired
    AutorService serviceAutor;
    //    @Autowired
//    film_autorService Servicefilm_autor;
    @Autowired
    CinemaService serviceCinemas;

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value*factor;
        long tmp = Math.round(value);
        return (double) tmp/factor;
    }
    


    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public java.lang.String Language(ModelMap model) {
        model.addAttribute("languages", serviceLanguages.findAllLanguagesMap());
        return "languages";
    }

    String forOut(String in) {
        return "<td>" + in + "</td>";
    }

    private List<String> categories(List<Integer> categ, Map<Integer, String> allCategories) {
        List<String> ans = new ArrayList<String>();
        for (Integer i : categ) ans.add(allCategories.get(i));
        return ans;
    }

    private List<String> categoryGet(Film film, Map<Integer, String> allCategories) {
        //if (film.getFilm_id() != 0) return allCategories.get(serviceFilms.getFilmCategories(film.getFilm_id()));
        return categories(serviceFilms.getFilmCategories(film.getFilm_id()), allCategories);
    }

    private <T> String listString(List<T> arr) {
        String ans = "";
        if (arr.size() != 0) ans += arr.get(0).toString();
        for (int i = 1; i < arr.size(); i++) {
            ans += ", " + arr.get(i).toString();
        }
        return ans;
    }

    @RequestMapping(value = {"/filmlist"}, method = RequestMethod.GET)
    public String listFilms(ModelMap model) {

        List<Film> films = serviceFilms.findAllFilms();
        Map<Integer, String> languages = serviceLanguages.findAllLanguagesMap();
        List<String> ss = new ArrayList<String>();
        Map<Integer, String> allAutors = serviceAutor.findAllAutorsMap();
        Map<Integer, String> allCategories = serviceFilms.AllCategoriesMap();
        int nIn = serviceFilms.Allin();

        for (Film film : films) {
            ssAdd(ss, film, allCategories, languages, allAutors, nIn);
        }

        model.addAttribute("filmer", new FilmListCategory());
        model.addAttribute("categories", serviceFilms.AllCategoriesMap());
        model.addAttribute("ss", ss);
        //model.addAttribute("nIn", nIn);
        return "allfilms";
    }

    boolean checkIfHaveCategory(List<Integer> lst, int category_id) {
        for (Integer i : lst) {
            if (i == category_id) return true;
        }
        return false;
    }

    Map<Integer, String> categoriess(Map<Integer, String> allCategories, List<Integer> lst) {
        Map<Integer, String> ans = new TreeMap<Integer, String>();
        for (Integer i : lst) {
            ans.put(i, allCategories.get(i));
        }
        return ans;
    }

    String getAutorsStr(Map<Integer, String> allAutors, List<Integer> lstAutors) {
        String ans = "";
        if (lstAutors.size() != 0) {
            ans += allAutors.get(lstAutors.get(0));
            for (int i = 1; i < lstAutors.size(); i++) {
                ans += ", " + allAutors.get(lstAutors.get(i));
            }
        }
        return ans;
    }

    private void ssAdd(List<String> ss, Film film, Map<Integer, String> allCategories, Map<Integer, String> languages,
                       Map<Integer, String> allAutors, int nIn) {
        List<Integer> lstAutors = serviceFilms.findAllFAutors(film.getFilm_id());
        int entres = serviceFilms.AllAt(film.getFilm_id());
        ss.add(forOut(film.getTitle() + "") +
                forOut(listString(categoryGet(film, allCategories))) +
                forOut(film.getDescription() + "") +
                forOut(film.getTiket_price() + "") +
                forOut(film.getCentral_rental_price() + "") +
                forOut(film.getRelease_year() + "") +
                forOut(languages.get(film.getLanguage_id())) +
                forOut(languages.get(film.getOriginal_language_id())) +
                forOut(getAutorsStr(allAutors, lstAutors)) +
                forOut(entres + "") +
                forOut(round(10*((double) entres/(double) nIn), 3) + "") +
                forOut(serviceFilms.pributok(film.getFilm_id()) + "") +
                forOut("<a href=/delete-" + film.getFilm_id() + "-film>" + film.getFilm_id() + "</a>"));
    }

    @RequestMapping(value = {"/filmlist"}, method = RequestMethod.POST)
    public String listFilmsIn(FilmListCategory filmer, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "/home";
        }
        List<Film> films = serviceFilms.findAllFilms();
        Map<Integer, String> languages = serviceLanguages.findAllLanguagesMap();
        List<String> ss = new ArrayList<String>();
        Map<Integer, String> allAutors = serviceAutor.findAllAutorsMap();
        Map<Integer, String> allCategories = serviceFilms.AllCategoriesMap();
        int nIn = serviceFilms.Allin();

        for (Film film : films) {
            if (filmer.Category_id == 0 ||
                    checkIfHaveCategory(serviceFilms.getFilmCategories(film.getFilm_id()), filmer.Category_id))
                ssAdd(ss, film, allCategories, languages, allAutors, nIn);
        }
        model.addAttribute("filmer", new FilmReg());
        model.addAttribute("categories", allCategories);
        model.addAttribute("ss", ss);
        return "allfilms";
    }

    private String mapStr(Map<Integer, String> allCategories) {
        String ans = "\"";
        //<option value="1">Criminal</option>
        for (Map.Entry<Integer, String> entry : allCategories.entrySet()) {
            ans += "<option value=\\\"" + entry.getKey() + "\\\">" + entry.getValue() + "</option>";
        }
        ans += "\"";
        return ans;
    }

    @RequestMapping(value = {"/newfilm"}, method = RequestMethod.GET)
    public String newFilm(ModelMap model) {
        FilmReg filmReg = new FilmReg();

        Map<Integer, String> allCategories = serviceFilms.AllCategoriesMap();
        Map<Integer, String> allAutors = serviceAutor.findAllAutorsMap();

        model.addAttribute("languages", serviceLanguages.findAllLanguagesMap());
        model.addAttribute("categories", allCategories);
        model.addAttribute("categoriesStr", mapStr(allCategories));
        model.addAttribute("film", filmReg);
        model.addAttribute("autor", allAutors);
        model.addAttribute("autorsStr", mapStr(allAutors));
        return "filmreg";
    }

    int findIntForFilm() {
        List<Film> films = serviceFilms.findAllFilms();
        int[] temp = new int[films.size()];
        for (int j = 0; j < films.size(); j++) {
            temp[j] = films.get(j).getFilm_id();
        }
        for (int i = 1; i < 10000; i++) {
            boolean out = true;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] == i) out = false;
            }
            if (out) return i;
        }
        return 111111;
    }

    private List<Integer> dellPowtors(List<Integer> in) {
        Set<Integer> temp = new HashSet<Integer>(in);
        in = new ArrayList<Integer>(temp);
        return in;
    }

    @RequestMapping(value = {"/newfilm"}, method = RequestMethod.POST)
    public java.lang.String saveFilm(FilmReg film, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "filmreg";
        }
        film.film_id = findIntForFilm();
        serviceFilms.saveFilm(film.Film());
        film.Category_id = dellPowtors(film.Category_id);
        Iterator<Integer> CrunchifyIterator = film.Category_id.iterator();
        while (CrunchifyIterator.hasNext()) {
            serviceFilms.putCategory(film.film_id, CrunchifyIterator.next());
        }
        film.Film_autor_id = dellPowtors(film.Film_autor_id);
        Iterator<Integer> CrunchifyIteratorF = film.Film_autor_id.iterator();
        while (CrunchifyIteratorF.hasNext()) {
            serviceFilms.insertAutor_in_film(film.film_id, CrunchifyIteratorF.next());
        }
        model.addAttribute("filmsuccess", "Film " + film.title
                + " registered successfully");
        return "filmsuccess";
    }
    
    /*
     * This method will delete an film by it's SSN value.
     */
    @RequestMapping(value = {"/delete-{film_id}-film"}, method = RequestMethod.GET)
    public java.lang.String deleteFilm(@PathVariable int film_id) {
        serviceFilms.deleteFilmByFilm_id(film_id);
        return "redirect:/filmlist";
    }


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        return "home";
    }


    void ssAddCinema(List<String> ss, Cinema cinema) {
        ss.add(
                forOut(cinema.getName() + "") +
                        forOut(serviceCinemas.getAddressByAddress_id(cinema.getAddress_id()) + "") +
                        forOut(cinema.getArea() + "") +
                        forOut(cinema.getComunal_pos() + "") +
                        forOut(cinema.getRent_pay() + "") +
                        forOut(cinema.getProduct() + "") +
                        forOut(cinema.getAbsolut_product() + "") +
                        forOut("<a href=/delete-" + cinema.getCinema_id() + "-cinema>" + cinema.getCinema_id() + "</a>"));
    }


    @RequestMapping(value = {"/cinemalist"}, method = RequestMethod.GET)
    public java.lang.String listCinemas(ModelMap model) {
        List<Cinema> cinemas = serviceCinemas.findAllCinemas();
        List<String> ss = new ArrayList<String>();
        for (Cinema cinema : cinemas) {
            ssAddCinema(ss, cinema);
        }
        model.addAttribute("cinemas", serviceCinemas.findAllCinemasMap());
        model.addAttribute("ss", ss);
        model.addAttribute("result", "");
        model.addAttribute("time", new StartEnd());
        return "allcinemas";
    }

    private String changeTimeFormat(String date) {
        date += ":01";
        return date.replace('T', ' ');
    }

    @RequestMapping(value = {"/cinemalist"}, method = RequestMethod.POST)
    public String saveCinema(StartEnd time, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "allcinemas";
        }
        List<String> ss = new ArrayList<String>();
        time.endTime = changeTimeFormat(time.endTime);
        time.startTime = changeTimeFormat(time.startTime);
        List<Cinema> cinemas = serviceCinemas.findAllCinemas();
        Map<Integer, String> cinemasMap = serviceCinemas.findAllCinemasMap();

        for (Cinema cinema : cinemas) {
            ssAddCinema(ss, cinema);
        }
        String res = "<pre>";
        if (time.cinema_id != 0) res += cinemasMap.get(time.cinema_id)+": " ;
        res += time.startTime + " - " + time.endTime;
        res += ", product = " + serviceFilms.pributok(time.cinema_id, time.startTime, time.endTime);
        res+="</pre>";
        model.addAttribute("result", res);
        model.addAttribute("cinemas", cinemasMap);
        model.addAttribute("ss", ss);
        model.addAttribute("time", new StartEnd());
        return "allcinemas";
    }

    @RequestMapping(value = {"/newcinema"}, method = RequestMethod.GET)
    public java.lang.String newCinema(ModelMap model) {
        Cinema cinema = new Cinema();
        model.addAttribute("cinema", cinema);
        model.addAttribute("address", serviceCinemas.findAllAddressMap());
        return "cinemareg";
    }

    @RequestMapping(value = {"/newcinema"}, method = RequestMethod.POST)
    public String saveCinema(Cinema cinema, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "cinemareg";
        }
        cinema.setAbsolut_product(new BigDecimal(2));
        serviceCinemas.saveCinema(cinema);
        model.addAttribute("cinemasuccess", "Cinema " + cinema.getName()
                + " registered successfully");
        return "cinemasuccess";
    }
    
    @RequestMapping(value = {"/delete-{cinema_id}-cinema"}, method = RequestMethod.GET)
    public java.lang.String deleteCinema(@PathVariable int cinema_id) {
        serviceCinemas.deleteCinemaByCinema_id(cinema_id);
        return "redirect:/cinemalist";
    }

    @RequestMapping(value = {"/ticketlist"}, method = RequestMethod.GET)
    public String listTickets(ModelMap model) {
        List<Ticket> tickets = serviceCinemas.findAllTickets();
        List<String> ss = new ArrayList<String>();
        for (Ticket ticket : tickets) {
            ss.add(
                    forOut(serviceCinemas.getCustomerName(ticket.customer_id) + "") +
                            forOut(serviceCinemas.findById(ticket.cinema_id).getName() + "") +
                            forOut(serviceFilms.findById(ticket.film_id).getTitle()) +
                            forOut(ticket.watching_date + "") +
                            forOut(ticket.pay + ""));
        }
        model.addAttribute("ss", ss);
        return "alltickets";
    }

    @RequestMapping(value = {"/newticket"}, method = RequestMethod.GET)
    public String newTicket(ModelMap model) {
        //Ticket ticket = new Ticket();
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("cinemas", serviceCinemas.findAllCinemasMap());
        model.addAttribute("films", serviceFilms.findAllFilmsMap());
        model.addAttribute("customers", serviceCinemas.findAllUsers());
        return "newticket";
    }
    
    @RequestMapping(value = {"/newticket"}, method = RequestMethod.POST)
    public String saveTicket(Ticket ticket, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "newticket";
        }
        ticket.watching_date = changeTimeFormat(ticket.watching_date);
        serviceCinemas.saveTicket(ticket);
        model.addAttribute("ticketsuccess", "Ticket pay" + ticket.pay
                + " registered successfully");
        return "ticketsuccess";
    }
    
}
