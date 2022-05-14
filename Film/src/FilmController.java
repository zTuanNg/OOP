import jdk.swing.interop.SwingInterOpUtils;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FilmController {
    static Scanner sc = new Scanner(System.in);
    static FilmService service = new FilmService();
    static List<Film> films;
    static {
        try {
            films = getListFilm();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void run(){


        while (true){

            menu();
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){

                // case 1
                case 1:
                    showListFilm();
                    break;

                // case 3
                case 3:
                    findFilmByCategory();

                // case 2
                case 2:
                    findFilmByName();
                    break;

                // case 4
                case 4:
                    threeFilmHightView();
                    break;

                // case 5
                case 5:
                    serialDone();

                // case 6
                case 6:
                    filmReleaseThisYear();

                case 7:
                    System.exit(0);
            }
        }




    }




    public static void menu(){
        System.out.println("1 - Show list film order by release date");
        System.out.println("2 - Find film by name");
        System.out.println("3 - Find film by category");
        System.out.println("4 - 3 films with highest views");
        System.out.println("5 - Show serial done");
        System.out.println("6 - List film release in this year");
        System.out.println("7 - Exit");
    }

    // get list film from filmservice
    public static List<Film> getListFilm() throws ParseException {
        return service.getListFilm();
    }

    // show list film order by release date
    public static void showListFilm(){
        List<Film> lst = service.sortByReleaseDate(films);
        Collections.reverse(lst);
        service.show(lst);
    }

    public static void findFilmByName(){
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        List<Film> rs = service.findByName(films,name);
        if(rs.size() != 0){
            service.show(rs);
        }else{
            System.out.println("Can not find this name");
        }
    }

    public static void threeFilmHightView(){
        List<Film> rs = service.sortByView(films);
        int i = 1;
        while (i < 4){
            System.out.println(rs.get(rs.size()-i));
            i++;
        }
    }

    public static void serialDone(){
        List<Serial> rs = service.findSerialDone(films);
        rs.forEach(f-> System.out.println(f));
    }

    public static void filmReleaseThisYear(){
        List<Film> rs = service.findFilmReleaseInYear(films);
        if(rs.size() != 0){
            service.show(rs);
        }else {
            System.out.println("Can not find films release this year");
        }
    }

    public static void findFilmByCategory(){
        System.out.println("Enter category (Mỗi thể loại cách nhau bằng dấu: space) ");
        String cate = sc.nextLine();
        cate = cate.trim();
        List<String> cates = List.of(cate.split("\\s+"));

        List<Film> rs = service.findByCategory(films,cates);
        if(rs.size() != 0){
            service.show(rs);
        }else{
            System.out.println("Can not find this category");
        }

    }

}
