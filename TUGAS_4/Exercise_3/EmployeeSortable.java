// EmployeeSortable.java
public class EmployeeSortable extends Sortable {
    protected String name;
    protected double salary;
    protected int hireDay, hireMonth, hireYear;

    public EmployeeSortable(String n, double s, int d, int m, int y) {
        name = n;
        salary = s;
        hireDay = d; hireMonth = m; hireYear = y;
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100.0;
    }

    public int hireYear() {
        return hireYear;
    }

    @Override
    public int compare(Sortable b) {
        EmployeeSortable eb = (EmployeeSortable) b;
        if (this.salary < eb.salary) return -1;
        if (this.salary > eb.salary) return 1;
        return 0;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear);
    }
}
