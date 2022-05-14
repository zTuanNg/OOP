package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private static int cnt;
    private int id;
    private String title;
    private String category;
    private String director;
    private Date date;

    {
        id = ++cnt;
    }

    public Film(String title, String category, String director, String date) throws ParseException {
        this.title = title;
        this.category = category;
        this.director = director;
        this.date = F.parse(date);
    }

    //toString

    @Override
    public String toString() {
        return String.format("--ID: %d\nTitle: %s\nCategory: %s\nDirector: %s\nDate: %s",
                this.id, this.title,this.category,this.director,F.format(this.date));
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
