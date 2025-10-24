package Task2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1️⃣ ArrayList
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student(101, "Budi", "Information Technology", "Bandung"));
        studentList.add(new Student(102, "Andi", "Computer Science", "Jakarta"));
        studentList.add(new Student(103, "Citra", "Mathematics", "Surabaya"));
        studentList.add(new Student(104, "Eka", "Computer Science", "Bandung"));
        studentList.add(new Student(105, "Dina", "Physics", "Yogyakarta"));

        Collections.sort(studentList, Comparator.comparing(Student::getName));

        System.out.println("=== Sorted Students (ArrayList) ===");
        for (Student s : studentList) {
            s.display();
        }

        // 2️⃣ Vector
        Vector<Student> studentVector = new Vector<>();

        studentVector.add(new Student(201, "Ali", "Computer Science", "Jakarta"));
        studentVector.add(new Student(202, "Bella", "Information System", "Bandung"));
        studentVector.add(new Student(203, "Chandra", "Computer Science", "Bogor"));
        studentVector.add(new Student(204, "Dewi", "Mathematics", "Surabaya"));
        studentVector.add(new Student(205, "Evan", "Physics", "Yogyakarta"));

        System.out.println("\n=== Students in Computer Science Department (Vector) ===");
        for (Student s : studentVector) {
            if (s.getDepartment().equalsIgnoreCase("Computer Science")) {
                s.display();
            }
        }
    }
}

