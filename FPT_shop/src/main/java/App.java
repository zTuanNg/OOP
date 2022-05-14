import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    public static void main(String[] args) {

        ProductController controller = new ProductController();
        controller.run();

    }

    public static class FilmService {

        // show films
        public void show(List<Film>lst){
            lst.forEach(f-> System.out.println(f));
        }

        // sort by release day
        public List<Film> sortByReleaseDay(List<Film> lst){
            return lst.stream().sorted(Comparator.comparing(f->f.getRelease_day())).collect(Collectors.toList());
        }
    }
}
