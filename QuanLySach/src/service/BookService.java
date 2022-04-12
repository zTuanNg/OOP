package service;

import model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {

    List<Book> ql = new ArrayList<>();

    // Add book
    public void addBook(Book book) {
        ql.add(book);
    }

    // Print list book
    public void printListBook(){
        ql.stream().forEach(b-> System.out.println(b));
    }

    // Find book by name
    public List<Book> findBookByName(String kw){
        return ql.stream().filter(b -> b.getTitle().contains(kw)).collect(Collectors.toList());
    }

    // Find book by category
    public List<Book> findBookByCategory(String kw){
        return ql.stream().filter(b -> b.getCategory().contains(kw)).collect(Collectors.toList());
    }

    // Sort book by page number
    public void sortbyPages(){
        this.ql.sort((b1,b2)->b1.sapXepByPage(b2));

    }

    // Sort by year
    public void sortbyYear(){
        this.ql.sort((b1,b2)->b1.sapXepByYear(b2));
    }

    // Sach xuat ban trong nam nay
    public List<Book> findBookThisYear(){
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt(String.valueOf(cal.get(Calendar.YEAR)));
        return this.ql.stream().filter(b->b.getRelease_year()==year).collect(Collectors.toList());

    }

    public List<Book> getQl() {
        return ql;
    }

    public void setQl(List<Book> ql) {
        this.ql = ql;
    }
}
