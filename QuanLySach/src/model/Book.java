package model;

import java.util.List;

public class Book {

    private static int cnt;
    private int id;
    private String title;
    private List<String> category;
    private String author;
    private int page_number;
    private int release_year;

    {
        id = ++cnt;
    }

    public Book(String title, List<String> category, String author, int page_number, int release_year) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.page_number = page_number;
        this.release_year = release_year;
    }

    @Override
    public String toString() {
        return "--Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", page_number=" + page_number +
                ", release_year=" + release_year +
                '}';
    }

    //
    public int sapXepByPage(Book b){
        return Integer.compare(this.page_number, b.getPage_number());
    }

    //
    public int sapXepByYear(Book b){
        return Integer.compare(this.release_year, b.getRelease_year());
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Book.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
}
