package model;

import java.text.SimpleDateFormat;

public class Staff {
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");
    private static int cnt;
    private String id;
    private String name;
    private Sex sex;
    private String phone;
    private String email;
    private String address;

    {
        id = "NV"+ String.format("%02d",++cnt);
    }

    // Constructor
    public Staff(String name, Sex sex, String phone, String email, String address) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // ToString


    @Override
    public String toString() {
        return "model.Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Getter Setter
    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Staff.cnt = cnt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

