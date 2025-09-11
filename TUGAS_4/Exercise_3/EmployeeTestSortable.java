// EmployeeTestSortable.java
public class EmployeeTestSortable {
    public static void main(String[] args) {
        EmployeeSortable[] staff = new EmployeeSortable[3];
        staff[0] = new EmployeeSortable("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new ManagerSortable("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new EmployeeSortable("Isabel Vidal", 3000000, 1, 11, 1993);

        // raise salary
        for (int i = 0; i < 3; i++) staff[i].raiseSalary(5);

        // sort using shell_sort (polymorphic; ManagerSortable is-a EmployeeSortable)
        Sortable.shell_sort(staff);

        for (int i = 0; i < 3; i++) staff[i].print();
    }
}
