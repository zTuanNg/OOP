package org.example;

import java.util.List;

public class Movie {
    private int id;
    private String title;
    private List<String> category;
    private String director;
    private int length;
    private String release;
    private int view;

    public Movie(int id, String title, List<String> category, String director, int length, String release, int view) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.release = release;
        this.view = view;
    }

    @Override
    public String toString() {
        return "--Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", director='" + director + '\'' +
                ", lenght=" + length +
                ", release='" + release + '\'' +
                ", view=" + view +
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLenght(int length) {
        this.length = length;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
