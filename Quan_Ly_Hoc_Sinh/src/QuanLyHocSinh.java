import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyHocSinh {

    List<Student> qlhs = new ArrayList<>();

    // print
    public void showListStudent(){
        qlhs.stream().forEach(s-> System.out.println(s));
    }

    // Add Student
    public void addStudent(Student s){
        qlhs.add(s);
    }

    // Remove Student by ID
    public void removeStudent(int id){
        try {
            Student s = qlhs.stream().filter(h -> h.getId()==id).findFirst().get();
            qlhs.remove(s);
        }
        catch (Exception e){
            System.out.printf("--Can not find ID = %d\n",id);
        }

    }

    // Update point
    public void updatePoint(){
        qlhs.stream().forEach(h->h.inputPoint());
    }

    // Show list Student by Class
    public void showStudentByClass(String s){
        List<Student> lst = qlhs.stream().filter(h ->h.getClassroom().equals(s)).collect(Collectors.toList());
        lst.stream().forEach(h-> System.out.println(h));
    }

    // còn sort by name -> hết ...
}
