// Commission.java
// Pegawai hourly + mendapat komisi penjualan

public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    // Tambah nilai penjualan
    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    // Hitung gaji = gaji hourly + komisi
    @Override
    public double pay() {
        double payment = super.pay(); // hitung gaji dari jam kerja
        payment += totalSales * commissionRate; // tambah komisi
        totalSales = 0; // reset setelah dibayar
        return payment;
    }

    // Tambahkan info total sales ke toString
    @Override
    public String toString() {
        String result = super.toString();
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}
