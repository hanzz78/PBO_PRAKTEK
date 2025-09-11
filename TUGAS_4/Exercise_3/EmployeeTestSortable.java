package Exercise_3;

public class EmployeeTestSortable {
    public static void main(String[] args) {
        EmployeeSortable[] staff = new EmployeeSortable[3];
        staff[0] = new EmployeeSortable("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new ManagerSortable("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new EmployeeSortable("Isabel Vidal", 3000000, 1, 11, 1993);

        for (EmployeeSortable e : staff) e.raiseSalary(5);

        Sortable.shell_sort(staff);

        for (EmployeeSortable e : staff) e.print();
    }
}
