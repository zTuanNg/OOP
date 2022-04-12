import model.Book;
import service.BookService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Language", Arrays.asList("Action","Drama"),"MrC",340,2010);
        Book b2 = new Book("Python Language",Arrays.asList("Drama","Romance", "War"),"DRZ",200,2011);
        Book b3 = new Book("Conan",Arrays.asList("Crime"),"Mrs.D",300,2022);

        BookService service = new BookService();

        // Add book
        service.addBook(b1);
        service.addBook(b2);
        service.addBook(b3);

        // Show info
        System.out.println("=====Show List Book=====");
        service.printListBook();

        // Sort by page
        System.out.println("\n=====Sort by page=====");
        service.sortbyPages();
        service.printListBook();

        // Sort by year
        System.out.println("\n=====Sort by year=====");
        service.sortbyYear();
        service.printListBook();

        // Find by name
        System.out.println("\n=====Find Book by name=====");
        List<Book> lst = service.findBookByName("Py");
        lst.stream().forEach(h-> System.out.println(h));

        // Find by category
        System.out.println("\n=====Find Book by category=====");
        List<Book> lst1 = service.findBookByCategory("Drama");
        lst1.stream().forEach(h-> System.out.println(h));

        // Find book release this year
        System.out.println("\n=====Find book release this year=====");
        List<Book> lst2 = service.findBookThisYear();
        lst2.stream().forEach(b-> System.out.println(b));

    }



}
