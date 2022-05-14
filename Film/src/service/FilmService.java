package service;

import model.Film;
import model.Movie;
import model.Serial;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FilmService {

    // get list film
    public List<Film> getListFilm() throws ParseException {
        Film m1 = new Movie("Runaway","desc1", Arrays.asList("Action","Animation","Comedy"),"24/01/1998",234,240);
        Film m2 = new Movie("Little Sister","desc2", Arrays.asList("Comedy"),"07/01/1998",550,550);
        Film m3 = new Movie("Lord of the Rings: The Fellowship of the Ring, The","desc3", Arrays.asList("Adventure","Fantasy"),"29/010/1978",254,240);

        Film m4 = new Serial("Tron: Legacy","desc4",Arrays.asList("Action","Adventure","Sci-Fi","IMAX"),"30/4/1996",600,20,"Done");
        Film m5 = new Serial("Sitter, The","desc5",Arrays.asList("Drama","Thriller"),"30/4/2022",400,20,"Not Done");
        Film m6 = new Serial("Thunderbolt and Lightfoot","desc6",Arrays.asList("Action","Comedy"),"21/4/2015",620,30,"Done");
        List<Film> lst = new ArrayList<>();
        lst.add(m1);
        lst.add(m2);
        lst.add(m3);
        lst.add(m4);
        lst.add(m5);
        lst.add(m6);

        return lst;
    }



    // show list film
    public void show(List<Film> films){
        films.forEach(f-> System.out.println(f));
    }

    // sort by release day
    public List<Film> sortByReleaseDate(List<Film>lst){
        return lst.stream().sorted(Comparator.comparing(f->f.getRelease_day())).collect(Collectors.toList());
    }

    // find by name
    public List<Film> findByName(List<Film>lst, String kw){
        try {
            return lst.stream().filter(f->f.getName().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }
        catch (Exception e){
            return null;
        }
    }

    // find by Category
    public List<Film> findByCategory(List<Film>lst, List<String>cate){
      try{

          for(Film f : lst){
              List<String> lst_cate = f.getCategory();
              List<String> rs = lst_cate.stream().map(String::toLowerCase).collect(Collectors.toList());
              f.setCategory(rs);
          }

          List<String> cate_fix = cate.stream().map(String::toLowerCase).collect(Collectors.toList());

          return lst.stream().filter(f->f.getCategory().containsAll(cate_fix)).collect(Collectors.toList());
      }
      catch (Exception e){
          return null;
      }
    }

    // sort controller.Film by view

    public List<Film> sortByView(List<Film> lst){
        return lst.stream().sorted(Comparator.comparingInt(f->f.getView())).collect(Collectors.toList());
    }

    // find controller.Serial
   public static List<Serial> findSerial(List<Film>lst){
        List<Serial> lstSerial = new ArrayList<>();

        for(Film f : lst){
            if(f instanceof Serial)
                lstSerial.add((Serial) f);
        }
        return lstSerial;
   }

   // find controller.Serial Done
    public List<Serial> findSerialDone(List<Film>lst) {
        try {
            List<Serial> lst_serial = findSerial(lst);
            return lst_serial.stream().filter(f->f.getStatus().equalsIgnoreCase("Done")).collect(Collectors.toList());
        }
        catch (Exception e) {
            return null;
        }
    }

    // controller.Film release in year
    public List<Film> findFilmReleaseInYear(List<Film> lst){

        SimpleDateFormat s = new SimpleDateFormat("yyyy");
        String timeStamp = s.format(Calendar.getInstance().getTime());

        try{
            return lst.stream().filter(f->s.format(f.getRelease_day()).equalsIgnoreCase(timeStamp)).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

}
