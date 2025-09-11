// ManagerSortable.java
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ManagerSortable extends EmployeeSortable {
    private String secretaryName;

    public ManagerSortable(String n, double s, int d, int m, int y) {
        super(n, s, d, m, y);
        secretaryName = "";
    }

    @Override
    public void raiseSalary(double byPercent) {
        GregorianCalendar todaysDate = new GregorianCalendar();
        int currentYear = todaysDate.get(Calendar.YEAR);
        double bonus = 0.5 * (currentYear - hireYear());
        super.raiseSalary(byPercent + bonus);
    }

    public String getSecretaryName() { return secretaryName; }
}

