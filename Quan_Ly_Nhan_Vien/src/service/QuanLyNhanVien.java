package service;

import model.Sex;
import model.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyNhanVien {

    List<Staff> qlnv = new ArrayList<>();

    // Add staff
    public void addStaff(Staff s){
        qlnv.add(s);
    }

    // Show all staff
    public void showAllStaff(){
        this.qlnv.forEach(s-> System.out.println(s));
    }

    // Find staff by name
    public List<Staff> findSaffByName(String kw){
        return this.qlnv.stream().filter(s->s.getName().toLowerCase().contains(kw.toLowerCase())).collect(Collectors.toList());
    }

    // Find staff by id
    public Staff findStaffByID(String id){
        return this.qlnv.stream().filter(s-> s.getId().toLowerCase().equals(id.toLowerCase())).findAny().get();
    }

    // Find by sex
    public List<Staff> findStaffBySex(Sex sex)
    {
        return this.qlnv.stream().filter(s->s.getSex().equals(sex)).collect(Collectors.toList());
    }

    // Find staff by Address
    public List<Staff> findStaffbyAdress(String address){
        return this.qlnv.stream().filter(s->s.getAddress().toLowerCase().equals(address.toLowerCase())).collect(Collectors.toList());
    }

}
