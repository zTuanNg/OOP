package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        BookService service = new BookService();

        List<Book> lst = service.readFile();

        List<Book> result = new ArrayList<>();

        System.out.println("===== Show List book info =====");
        service.showInfo(lst);
        System.out.println("-------------------------------------------");

        System.out.println("===== Find book by name");
        System.out.println("Enter name : ");
        result = service.findBookByName(lst,sc.nextLine());
        if(result.size()==0)
            System.out.println("Can not find this name");
        else
            service.showInfo(result);
        System.out.println("-------------------------------------------");

        System.out.println("===== Find book by category");
        System.out.println("Enter category : ");
        result = service.findBookByCategory(lst,sc.nextLine());
        if(result.size()==0)
            System.out.println("Can not find this category");
        else
            service.showInfo(result);
        System.out.println("-------------------------------------------");

        System.out.println("===== Sort book by page number ");
        result = service.sortByPageNumber(lst);
        service.showInfo(result);
        System.out.println("-------------------------------------------");

        System.out.println("===== Sort book by year realse ");
        result = service.sortByYearRelease(lst);
        service.showInfo(result);
        System.out.println("-------------------------------------------");




    }
}
