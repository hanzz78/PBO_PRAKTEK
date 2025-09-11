package Exercise_3;

public class EmployeeSortable extends Sortable {
    protected String name;
    protected double salary;
    protected int hireDay, hireMonth, hireYear;

    public EmployeeSortable(String n, double s, int d, int m, int y) {
        this.name = n;
        this.salary = s;
        this.hireDay = d; this.hireMonth = m; this.hireYear = y;
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
        return Double.compare(this.salary, eb.salary);
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear);
    }
}
