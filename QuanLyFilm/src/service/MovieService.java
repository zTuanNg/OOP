package service;

import model.Film;
import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    List<Movie> movies = new ArrayList<>();

    // Add movie
    public void addMovie(Movie m){
        movies.add(m);
    }

    // show info movie
    public void showInfoMovie(){
        this.movies.forEach(m-> System.out.println(m));
    }

}
