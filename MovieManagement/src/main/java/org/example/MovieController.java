package org.example;

import java.util.List;

public class MovieController {

    public static void run(){
        MovieService service = new MovieService();
        List<Movie> movies = service.readFile();

        System.out.println("=== Show info movies ===");
        service.showInfo(movies);

        System.out.println();
        System.out.println("=== Sort by title ===");
        movies = service.sortByTitle(movies);
        service.showInfo(movies);

        System.out.println();
        System.out.println("=== Sort by lenght ===");
        movies = service.sortByLength(movies);
        service.showInfo(movies);

        System.out.println();
        System.out.println("=== Sort by view ===");
        movies = service.sortByView(movies);
        service.showInfo(movies);

        System.out.println();
        System.out.println("=== Count movie by category ===");
        System.out.println(service.countMovieByCategory(movies));

    }
}
