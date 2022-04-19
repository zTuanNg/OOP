package controller;

import model.Student;
import service.StudentService;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {

    static Scanner sc = new Scanner(System.in);






    public static void run() {
        StudentService service = new StudentService();
        List<Student> lst = new ArrayList<>();
        lst.add(new Student("Nguyen Van Sang",16,"HN",9,"Class A"));
        lst.add(new Student("Dinh Trong Tue",19,"HN",7.5,"Class A"));
        lst.add(new Student("Nguyen Phuong Anh",16,"HCM",8.5,"Class A"));
        lst.add(new Student("Nguyen Minh Tuan",18,"HN",9.5,"Class B"));
        lst.add(new Student("Dao Ba Tung",17,"HCM",9,"Class B"));



        while(true) {
            menu();
            System.out.println("Please choice option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {
                case 1:
                    System.out.println("=== Show list student ===");
                    service.showListStudent(lst);
                    break;

                case 2:
                    System.out.println("=== Add student ===");
                    service.addStudent(lst,inputInfoStuden());
                    break;

                case 3:
                    System.out.println("=== Find student by ID ===");
                    System.out.println("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Student p = service.findByID(lst,id);
                    if(p != null){
                        System.out.println(p);
                        menu1();
                        System.out.println("Choice option: ");
                        choice = Integer.parseInt(sc.nextLine());
                        if (choice == 1){
                            service.removeStudent(lst,p);
                        }
                        if(choice == 2){
                            System.out.println("Enter point: ");
                            double point = Double.parseDouble(sc.nextLine());
                            service.updatePoint(p,point);
                            System.out.println(p);
                        }
                        if(choice == 3){break;}
                    }
                    else{
                        System.out.println("Can't not find this ID");
                    }
                    break;

                case 4:
                    System.out.println("=== Find student by classroom ===");
                    System.out.println("Enter classroom: ");
                    String cls = sc.nextLine();
                    List<Student> l1 = service.findStudentByClassroom(lst,cls);
                    service.showListStudent(l1);
                    break;

                case 5:
                    System.out.println("=== Sort by name ===");
                    List<Student> l2 = service.sortByName(lst);
                    service.showListStudent(l2);
                    break;

                case 6:
                    System.out.println("=== Sort by age ===");
                    List<Student> l3 = service.sortByAge(lst);
                    service.showListStudent(l3);
                    break;

                case 7:
                    System.out.println("=== Sort by point ===");
                    List<Student> l4 = service.sortByPoint(lst);
                    service.showListStudent(l4);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Try again");
            }
        }


    }

    public static void menu(){
        System.out.println("=== [MAIN MENU] ===");
        System.out.println("1 - Show list student");
        System.out.println("2 - Add student");
        System.out.println("3 - Find student by ID");
        System.out.println("4 - Find student by classroom");
        System.out.println("5 - Sort by name");
        System.out.println("6 - Sort by age");
        System.out.println("7 - Sort by point");
        System.out.println("0 - Exit");
    }

    public static void menu1(){
        System.out.println("1 - Remove");
        System.out.println("2 - Update point");
        System.out.println("3 - Back main menu");
    }

    public static Student inputInfoStuden(){
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter Age: ");
        int age  = Integer.parseInt(sc.nextLine());
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter point: ");
        double point = Double.parseDouble(sc.nextLine());
        System.out.println("Enter classroom: ");
        String classroom = sc.nextLine();

        return new Student(name, age,address,point,classroom);
    }

}
