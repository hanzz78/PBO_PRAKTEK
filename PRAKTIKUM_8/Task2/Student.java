package Task2;
public class Student {
    private int studentID;
    private String name;
    private String department;
    private String address;

    public Student(int studentID, String name, String department, String address) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public Student(int studentID, String name, int departmentCode, String address) {
        this.studentID = studentID;
        this.department = "Dept-" + departmentCode;
        this.name = name;
        this.address = address;
    }

    public int getStudentID() { return studentID; }
    public void setStudentID(int studentID) { this.studentID = studentID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public void display() {
        System.out.println("ID: " + studentID + ", Name: " + name + ", Department: " + department + ", Address: " + address);
    }
}
