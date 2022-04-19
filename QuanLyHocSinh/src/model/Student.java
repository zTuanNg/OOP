package model;

public class Student {

    private static int cnt;
    private int id;
    private String name;
    private int age;
    private String address;
    private double point;
    private String classroom;

    {
        id = ++cnt;
    }

    public Student(String name, int age, String address, double point, String classroom) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.point = point;
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "--Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", point=" + point +
                ", classroom='" + classroom + '\'' +
                '}';
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Student.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
