// Executive.java
// Pegawai eksekutif yang dapat bonus

public class Executive extends Employee {
    private double bonus;

    public Executive(String eName, String eAddress, String ePhone,
                     String socSecNumber, double rate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        bonus = 0; // belum ada bonus
    }

    public void awardBonus(double execBonus) {
        bonus = execBonus;
    }

    @Override
    public double pay() {
        double payment = super.pay() + bonus;
        bonus = 0; // reset bonus setelah dibayar
        return payment;
    }
}
