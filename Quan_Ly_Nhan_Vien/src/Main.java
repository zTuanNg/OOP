import model.Sex;
import model.Staff;
import service.QuanLyNhanVien;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Staff s1 = new Staff("Nguyen Van A", Sex.MALE, "0123456", "nguyena@gmail.com", "Ha Noi");
        Staff s2 = new Staff("Trinh Trong B", Sex.FEMALE, "435234234", "b@gmail.com", "HCM");
        Staff s3 = new Staff("Nguyen", Sex.MALE,"012833","n@gmail.com","ha noi");

        QuanLyNhanVien qlnv = new QuanLyNhanVien();

        // Add staff
        qlnv.addStaff(s1);
        qlnv.addStaff(s2);
        qlnv.addStaff(s3);

        // Show All model.Staff
        System.out.println("=====SHOW ALL STAFF=====");
        qlnv.showAllStaff();

        // find by ID
        System.out.println("=====FIND STAFF BY ID=====");
        try {
            Staff s = qlnv.findStaffByID("nv01");
            System.out.println(s);
        }
        catch (Exception e){
            System.out.println("Can not find this ID");
        }

        // find by name
        System.out.println("=====FIND STAFF BY NAME=====");
        List<Staff> lst = qlnv.findSaffByName("A");
        if (lst == null){
            System.out.println("Can not find this name");
        }else {
            lst.forEach(s-> System.out.println(s));
        }

        // List by sex
        System.out.println("=====LIET KE THEO GIOI TINH=====");
        System.out.println("--MALE--");
        List<Staff> lst2 = qlnv.findStaffBySex(Sex.MALE);
        lst2.forEach(System.out::println);
        System.out.println("--FEMALE--");
        List<Staff> lst3 = qlnv.findStaffBySex(Sex.FEMALE);
        lst3.forEach(s-> System.out.println(s));

        //find model.Staff in Hanoi
        System.out.println("=====FIND STAFF IN HANOI=====");
        List<Staff> lst4 = qlnv.findStaffbyAdress("ha noi");
        lst4.forEach(s-> System.out.println(s));
    }
}

