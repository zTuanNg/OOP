package model;

import model.Film;

import java.text.ParseException;

public class Movie extends Film {

    private int time;

    public Movie(String title, String category, String director, String date, int time) throws ParseException {
        super(title, category, director, date);
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%s\nTime: %d",super.toString(),this.time);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
