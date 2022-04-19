package service;

import model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    // Show List model.Student
    public void showListStudent(List<Student> lst){
        lst.forEach(s-> System.out.println(s));
    }

    // Add student
    public void addStudent(List<Student> lst, Student s){
        lst.add(s);
    }

    // Find model.Student by id
    public Student findByID(List<Student> lst, int id){
        try {
            return lst.stream().filter(s->s.getId()==id).findAny().get();
        }
        catch (Exception e){
            return null;
        }
    }

    // Update point
    public void updatePoint(Student s, double point){
        s.setPoint(point);
    }

    // Remove model.Student
    public void removeStudent(List<Student> lst,Student s){
        lst.remove(s);
    }

    // Find list model.Student by classroom
    public List<Student> findStudentByClassroom(List<Student>lst, String kw){
        try {
            return lst.stream().filter(s->s.getClassroom().toLowerCase().equals(kw.toLowerCase())).collect(Collectors.toList());
        }
        catch(Exception e){
            return null;
        }
    }

    // Sort by name
    public List<Student> sortByName(List<Student>lst){
        return lst.stream().sorted(Comparator.comparing(s->s.getName())).collect(Collectors.toList());
    }

    // Sort by age
    public List<Student> sortByAge(List<Student> lst){
        return lst.stream().sorted(Comparator.comparingInt(s->s.getAge())).collect(Collectors.toList());
    }

    // Sort by point
    public List<Student> sortByPoint(List<Student> lst){
       return lst.stream().sorted(Comparator.comparingDouble(s->s.getPoint())).collect(Collectors.toList());
    }




}
