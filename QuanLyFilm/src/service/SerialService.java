package service;

import model.Serial;

import java.util.ArrayList;
import java.util.List;

public class SerialService {

    List<Serial> series = new ArrayList<>();

    // Add serial
    public void addSerial(Serial serial){
        series.add(serial);
    }

    // Show info serial
    public void showInfoSerial(){
        this.series.forEach(s-> System.out.println(s));
    }
}
