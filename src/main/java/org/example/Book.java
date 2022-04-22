package org.example;

import java.util.List;

public class Book {

    private int id;
    private String title;
    private List<String> category;
    private String author;

    private int pageNumber;

    private int releaseYear;

    public Book(){};

    public Book(int id, String title, List<String> category, String author, int pageNumber, int releaseYear) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;

        this.pageNumber = pageNumber;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "--Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", author='" + author + '\'' +
                ", pageNumber='" + pageNumber + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}

