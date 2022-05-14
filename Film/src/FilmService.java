import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FilmService {

    // get list film
    public List<Film> getListFilm() throws ParseException {
        Film m1 = new Movie("name1 name11","desc1", Arrays.asList("A","B","C"),"24/01/1998",234,240);
        Film m2 = new Movie("name2","desc2", Arrays.asList("A","B"),"07/01/1998",550,550);
        Film m3 = new Movie("name2","desc2", Arrays.asList("D","B","C"),"29/010/1978",254,240);

        Film m4 = new Serial("name3","desc3",Arrays.asList("A","B"),"30/4/1996",600,20,"Done");
        Film m5 = new Serial("name4","desc4",Arrays.asList("A","B"),"30/4/2022",400,20,"Not Done");
        List<Film> lst = new ArrayList<>();
        lst.add(m1);
        lst.add(m2);
        lst.add(m3);
        lst.add(m4);
        lst.add(m5);

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

    // sort Film by view

    public List<Film> sortByView(List<Film> lst){
        return lst.stream().sorted(Comparator.comparingInt(f->f.getView())).collect(Collectors.toList());
    }

    // find Serial
   public static List<Serial> findSerial(List<Film>lst){
        List<Serial> lstSerial = new ArrayList<>();

        for(Film f : lst){
            if(f instanceof Serial)
                lstSerial.add((Serial) f);
        }
        return lstSerial;
   }

   // find Serial Done
    public List<Serial> findSerialDone(List<Film>lst) {
        try {
            List<Serial> lst_serial = findSerial(lst);
            return lst_serial.stream().filter(f->f.getStatus().equalsIgnoreCase("Done")).collect(Collectors.toList());
        }
        catch (Exception e) {
            return null;
        }
    }

    // Film release in year
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
