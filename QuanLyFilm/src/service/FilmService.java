package service;

import model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmService {

    List<Film> films = new ArrayList<>();

    // Add Film
    public void addFilm(Film f){
        this.films.add(f);
    }

    // show Info Film
    public void showInfoFilm(){
        this.films.forEach(f-> System.out.println(f));
    }

    // Find Film by title
    public List<Film> findFilmByTitle(String title){
        return this.films.stream().filter(f->f.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    }
}
