package model;

import model.Film;

import java.text.ParseException;

public class Serial extends Film {

    private int period;
    private int avgTime;

    public Serial(String title, String category, String director, String date, int period, int avgTime) throws ParseException {
        super(title, category, director, date);
        this.period = period;
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return String.format("%s\nPeriod: %d\nAverage Time: %d",super.toString(),this.period,this.avgTime);
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }
}
