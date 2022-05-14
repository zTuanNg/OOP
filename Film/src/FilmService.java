import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FilmService {

    public void show(List<Film> films){
        films.forEach(f-> System.out.println(f));
    }

    // sort by release day
    public void sortByReleaseDate(List<Film>lst){
        lst.stream().sorted(Comparator.comparing(f->f.getRelease_day())).collect(Collectors.toList());
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
