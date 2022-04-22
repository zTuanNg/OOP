
package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BookService {


    // json -> list
    public List<Book> readFile(){

        List<Book> books = new ArrayList<>();
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("./Book_Management/Book.json");
            books = gson.fromJson(reader, new TypeToken<ArrayList<Book>>() {}.getType());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    // show info
    public void showInfo(List<Book>lst){
        lst.forEach(b-> System.out.println(b));
    }

    // find book by name
    public List<Book> findBookByName(List<Book>lst, String kw){
        try {
            return lst.stream().filter(b->b.getTitle().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

    // find book by category
    public List<Book> findBookByCategory(List<Book>lst,String kw){
        try {
            return (lst.stream().filter(b->b.getCategory().contains(kw)).collect(Collectors.toList()));
        }
        catch (Exception e){
            return null;
        }
    }

    // Sort by page number
    public List<Book> sortByPageNumber(List<Book>lst){
        try{
            return lst.stream().sorted(Comparator.comparingInt(b->b.getPageNumber())).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

    // Sort by year
    public List<Book> sortByYearRelease(List<Book>lst){
        try{
            return lst.stream().sorted(Comparator.comparingInt(b->b.getReleaseYear())).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }


}
