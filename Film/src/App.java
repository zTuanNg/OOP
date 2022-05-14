import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws ParseException {
       Film m1 = new Movie("name1 name11","desc1", Arrays.asList("A","B","C"),"24/01/1998",234,240);
        Film m2 = new Movie("name2","desc2", Arrays.asList("A","B"),"07/01/1998",214,240);
        Film m3 = new Movie("name2","desc2", Arrays.asList("D","B","C"),"29/010/1978",254,240);

        Film m4 = new Serial("name3","desc3",Arrays.asList("A","B"),"30/4/1996",400,20,"Done");
        Film m5 = new Serial("name4","desc4",Arrays.asList("A","B"),"30/4/2022",400,20,"Not Done");
        List<Film> lst = new ArrayList<>();
        lst.add(m1);
        lst.add(m2);
        lst.add(m3);
        lst.add(m4);
        lst.add(m5);

        List<String> s = Arrays.asList("C");

        FilmService fsv = new FilmService();

//        List<Film> rs = fsv.sortByView(lst);
//        rs.forEach(f-> System.out.println(f));

//        List<Serial> serial = fsv.findSerialDone(lst);
//        serial.forEach(f-> System.out.println(f));

    List<Film> rs = fsv.findFilmReleaseInYear(lst);
    rs.forEach(f-> System.out.println(f));





    }
}
