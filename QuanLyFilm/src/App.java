import model.Film;
import model.Movie;
import model.Serial;
import service.FilmService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void main(String[] args) throws ParseException {

        Movie m1 = new Movie("Movie 1","Kinh di","MrA","24/1/1998",240);
        Serial s1 = new Serial("Seri 1","Kinh di","MrsB","20/5/1996",30,45);
        Movie m2 = new Movie("Batman","Hanh dong","MrC","30/9/2020",300);
        Serial s2 = new Serial("Nguoi phan xu","Hinh su","MrD","21/7/2019",45,30);

        FilmService ql = new FilmService();

        // Add film
        ql.addFilm(m1);
        ql.addFilm(s1);
        ql.addFilm(m2);
        ql.addFilm(s2);

        // Show info film
        System.out.println("======Show film info=====");
        ql.showInfoFilm();

        //  Find film by title
        System.out.println("=====Find film by title");
        List<Film> lst = ql.findFilmByTitle("nguoi");
        lst.stream().forEach(h-> System.out.println(h));



    }
}
