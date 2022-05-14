package model;

import java.text.ParseException;
import java.util.List;

public class Serial extends Film {
    private int period;
    private String status;

    public Serial(){
        super();
    }

    public Serial(String name, String desc, List<String> category, String release_day, int view,int period, String status) throws ParseException {
        super(name,desc, category, release_day, view);
        this.period = period;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s - period: %s - status: %s",super.toString(),this.period,this.status);
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
