package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieService {

    public List<Movie> readFile(){

        Gson gson = new Gson();
        List<Movie> movies = new ArrayList<>();
        try {
            FileReader reader = new FileReader("./MovieManagement/movie.json");
            movies = gson.fromJson(reader,new TypeToken<ArrayList<Movie>>() {}.getType());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }

    public void showInfo(List<Movie> movies){
        movies.forEach(System.out::println);
    }

    // sort by lenght
    public List<Movie> sortByLength(List<Movie> movies){
        return movies.stream().sorted(Comparator.comparingInt(Movie::getLength)).collect(Collectors.toList());
    }

    // sort by view
    public List<Movie> sortByView(List<Movie> movies){
        return movies.stream().sorted(Comparator.comparingInt(Movie::getView)).collect(Collectors.toList());
    }

    // sort by title
    public List<Movie> sortByTitle(List<Movie> movies){
        return movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());
    }

    // count number movie each category

    public Map<String,Integer> countMovieByCategory(List<Movie> movies){
        List<String> categories = movies.stream().flatMap(m->m.getCategory().stream()).collect(Collectors.toList());
        Set<String> cate = new HashSet(categories);
        Map<String, Integer> map = new HashMap<>();
        for(String category : cate){
            int count = (int) movies.stream().filter(m->m.getCategory().contains(category)).count();
            map.put(category, count);
        }
        return map;
    }


}
