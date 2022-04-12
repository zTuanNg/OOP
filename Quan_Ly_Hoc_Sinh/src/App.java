public class App {
    public static void main(String[] args) {
        Student s1 = new Student("Nguyen Dinh B",15,"HN","10A1");
        Student s2 = new Student("Tran Van A",20,"HN","10A2");


        QuanLyHocSinh qlhs = new QuanLyHocSinh();

        // Add
        qlhs.addStudent(s1);
        qlhs.addStudent(s2);

        // Update point
        qlhs.updatePoint();

        // Show info
        qlhs.showListStudent();

        // Show student by class
        qlhs.showStudentByClass("10A1");

        // Sort by name
//        qlhs.sortByName();
//        qlhs.showListStudent();
    }
}
