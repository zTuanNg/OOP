package model;

import java.text.ParseException;
import java.util.List;

public class Movie extends Film {

    private int time;

    public Movie(){
        super();
    }

    public Movie(String name,String desc, List<String> category, String release_day, int view, int time) throws ParseException {
        super(name,desc, category, release_day, view);
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("%s - time: %s",super.toString(),this.time);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
