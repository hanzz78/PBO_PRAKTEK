import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Kelas ini membuat GUI fungsional untuk aplikasi Point of Sales
 * sesuai dengan Latihan dan Praktikum (Halaman 15-21).
 * * Kita implementasikan ActionListener (untuk tombol)
 * dan ListSelectionListener (untuk tabel).
 */
public class PointOfSales extends JFrame implements ActionListener, ListSelectionListener {

    // --- Deklarasi Komponen GUI ---
    // Kita jadikan variabel global agar bisa diakses dari semua method
    private JTable tabelProduk;
    private JTable tabelKeranjang;
    private DefaultTableModel modelKeranjang;
    
    private JButton btnAddToCart;
    private JButton btnCheckout;
    private JButton btnPrint;
    
    private JTextField txtQty;
    private JTextArea txtStruk;
    
    private JLabel lblDipilih;
    private JLabel lblTotal;
    private JLabel lblPoints;

    // --- Variabel untuk data ---
    private Object[] selectedProductData = null; // Menyimpan data produk yg diklik
    private int totalBelanja = 0;
    private int totalPoints = 0;
    
    // Format Rupiah
    private NumberFormat formatRupiah;

    // Konstruktor untuk setup frame utama
    public PointOfSales() {
        // 1. Setup Frame Utama (JFrame)
        setTitle("POIN Off-Sales - Java Swing"); // [cite: 108]
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Setup format Rupiah
        formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        // 2. Buat Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File"); // [cite: 109]
        JMenu menuHelp = new JMenu("Help"); // [cite: 109]
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        setJMenuBar(menuBar);

        // 3. Buat Panel Kiri (Produk)
        JPanel panelKiri = createProductPanel();

        // 4. Buat Panel Kanan (Keranjang, Kontrol, Struk)
        JPanel panelKanan = createSalesPanel();

        // 5. Gabungkan Panel Kiri dan Kanan
        JSplitPane splitPaneUtama = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelKiri, panelKanan);
        splitPaneUtama.setDividerLocation(400);

        add(splitPaneUtama, BorderLayout.CENTER);
    }

    // Method untuk membuat panel kiri (Daftar Produk)
    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Produk"), BorderLayout.NORTH); // [cite: 109]

        // Data untuk tabel produk [cite: 111]
        String[] kolomProduk = {"ID", "Nama Produk", "Harga (Rp)"};
        Object[][] dataProduk = {
            {"P001", "Air Mineral 600ml", 3000},
            {"P002", "Kopi Sachet", 5000},
            {"P003", "Roti isi", 8000},
            {"P004", "Snack Keripik", 6000},
            {"P005", "Minuman Botol", 12000}
        };

        // Buat JTable
        // Kita gunakan DefaultTableModel agar tidak bisa diedit
        DefaultTableModel modelProduk = new DefaultTableModel(dataProduk, kolomProduk) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat sel tabel tidak bisa diedit
            }
        };
        tabelProduk = new JTable(modelProduk);
        tabelProduk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Hanya bisa pilih 1 baris
        
        // **TAMBAHKAN LISTENER**
        tabelProduk.getSelectionModel().addListSelectionListener(this);

        JScrollPane scrollPane = new JScrollPane(tabelProduk);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Method untuk membuat panel kanan (Keranjang, Kontrol, Struk)
    private JPanel createSalesPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // --- Panel Kanan Atas (Keranjang) ---
        JPanel panelKeranjang = new JPanel(new BorderLayout(5, 5));
        panelKeranjang.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelKeranjang.add(new JLabel("Keranjang"), BorderLayout.NORTH); // [cite: 110]

        // Buat tabel keranjang (kosong) [cite: 112-116]
        String[] kolomKeranjang = {"ID", "Nama Produk", "Qty", "Harga", "Subtotal"};
        modelKeranjang = new DefaultTableModel(kolomKeranjang, 0);
        tabelKeranjang = new JTable(modelKeranjang);
        panelKeranjang.add(new JScrollPane(tabelKeranjang), BorderLayout.CENTER);
        
        // --- Panel Kanan Bawah (Kontrol dan Struk) ---
        JPanel panelBawah = new JPanel(new GridLayout(1, 2, 10, 10)); 
        panelBawah.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel Kontrol (kiri-bawah)
        JPanel panelKontrol = new JPanel();
        panelKontrol.setLayout(new BoxLayout(panelKontrol, BoxLayout.Y_AXIS)); 

        lblDipilih = new JLabel("Pilih produk dari tabel di kiri"); // [cite: 117]
        panelKontrol.add(lblDipilih);
        panelKontrol.add(Box.createRigidArea(new Dimension(0, 10))); 

        // Panel untuk Qty (horizontal)
        JPanel panelQty = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelQty.add(new JLabel("Qty:")); // [cite: 118]
        txtQty = new JTextField("1", 5); // [cite: 118]
        panelQty.add(txtQty);
        panelKontrol.add(panelQty);

        btnAddToCart = new JButton("Add to Cart"); // [cite: 119]
        panelKontrol.add(btnAddToCart);
        panelKontrol.add(Box.createRigidArea(new Dimension(0, 20))); 
        
        lblTotal = new JLabel("Total: Rp0,00"); // [cite: 120]
        panelKontrol.add(lblTotal);
        lblPoints = new JLabel("Points: 0"); // [cite: 121]
        panelKontrol.add(lblPoints);
        panelKontrol.add(Box.createRigidArea(new Dimension(0, 10))); 
        
        btnCheckout = new JButton("Checkout"); // [cite: 122]
        panelKontrol.add(btnCheckout);
        panelKontrol.add(Box.createRigidArea(new Dimension(0, 5))); 
        
        btnPrint = new JButton("Cetak"); // [cite: 123]
        panelKontrol.add(btnPrint);
        
        // **TAMBAHKAN LISTENER**
        btnAddToCart.addActionListener(this);
        btnCheckout.addActionListener(this);
        btnPrint.addActionListener(this);

        // Panel Struk (kanan-bawah)
        JPanel panelStruk = new JPanel(new BorderLayout(5, 5));
        panelStruk.add(new JLabel("Struk:"), BorderLayout.NORTH); // [cite: 124]
        txtStruk = new JTextArea(); 
        txtStruk.setEditable(false);
        txtStruk.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Font agar rapi
        panelStruk.add(new JScrollPane(txtStruk), BorderLayout.CENTER);

        // Masukkan panel kontrol dan struk ke panelBawah
        panelBawah.add(panelKontrol);
        panelBawah.add(panelStruk);

        // Gabungkan panelKeranjang dan panelBawah
        JSplitPane splitPaneKanan = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelKeranjang, panelBawah);
        splitPaneKanan.setDividerLocation(300); 

        panel.add(splitPaneKanan, BorderLayout.CENTER);
        return panel;
    }

    // --- METHOD UNTUK EVENT HANDLING ---

    /**
     * Method ini dipanggil setiap kali ada tombol yang diklik.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cek tombol mana yang diklik
        if (e.getSource() == btnAddToCart) {
            aksiAddToCart();
        } else if (e.getSource() == btnCheckout) {
            aksiCheckout();
        } else if (e.getSource() == btnPrint) {
            aksiPrint();
        }
    }

    /**
     * Method ini dipanggil setiap kali pilihan di tabelProduk berubah.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        // Pastikan event tidak sedang dalam proses adjust
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelProduk.getSelectedRow();
            
            // Jika ada baris yang dipilih
            if (selectedRow != -1) {
                // Ambil data dari baris tsb
                String id = tabelProduk.getValueAt(selectedRow, 0).toString();
                String nama = tabelProduk.getValueAt(selectedRow, 1).toString();
                int harga = (int) tabelProduk.getValueAt(selectedRow, 2);
                
                // Simpan di variabel global
                selectedProductData = new Object[]{id, nama, harga};
                
                // Update label "Dipilih" (sesuai Halaman 18 )
                lblDipilih.setText(String.format("Dipilih: %s - %s (%s)",
                        id, nama, formatRupiah.format(harga)));
            }
        }
    }

    // --- METHOD UNTUK LOGIKA AKSI ---

    /**
     * Logika untuk tombol "Add to Cart".
     */
    private void aksiAddToCart() {
        // 1. Pastikan ada produk yang dipilih
        if (selectedProductData == null) {
            JOptionPane.showMessageDialog(this, "Silakan pilih produk terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Ambil Qty dari JTextField
        int qty;
        try {
            qty = Integer.parseInt(txtQty.getText());
            if (qty <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Qty harus berupa angka positif.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. Ambil data produk yang dipilih
        String id = selectedProductData[0].toString();
        String nama = selectedProductData[1].toString();
        int harga = (int) selectedProductData[2];
        
        // 4. Hitung subtotal
        int subtotal = harga * qty;

        // 5. Tambahkan ke tabel keranjang [cite: 138]
        modelKeranjang.addRow(new Object[]{id, nama, qty, formatRupiah.format(harga), formatRupiah.format(subtotal)});

        // 6. Update total dan reset
        updateTotalAndPoints();
        resetInput();
    }
    
    /**
     * Logika untuk tombol "Checkout".
     */
    private void aksiCheckout() {
        // 1. Pastikan keranjang tidak kosong
        if (modelKeranjang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang belanja masih kosong.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // 2. Buat teks Struk (sesuai Halaman 20 [cite: 191-195])
        StringBuilder struk = new StringBuilder();
        struk.append("===== POIN OFF-SALES =====\n");
        struk.append("Toko: Demo Toko\n");
        struk.append("---------------------------------\n");
        
        // Loop isi keranjang
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            String id = modelKeranjang.getValueAt(i, 0).toString();
            String nama = modelKeranjang.getValueAt(i, 1).toString();
            int qty = (int) modelKeranjang.getValueAt(i, 2);
            String subtotal = modelKeranjang.getValueAt(i, 4).toString();
            
            // Format struk per baris [cite: 191]
            struk.append(String.format("%-5s %-15s %dx %s\n", id, nama, qty, subtotal));
        }
        
        struk.append("---------------------------------\n");
        struk.append(String.format("TOTAL:\t\t%s\n", formatRupiah.format(totalBelanja))); // [cite: 192, 193]
        struk.append(String.format("POINTS DIDAPAT:\t%d\n", totalPoints)); // [cite: 194]
        struk.append("(1 point per Rp 1000)\n"); // [cite: 194]
        struk.append("\nTerima kasih! Silakan kunjungi kembali.\n"); // [cite: 195]

        // 3. Tampilkan di JTextArea
        txtStruk.setText(struk.toString());
        
        // 4. Kosongkan keranjang dan reset total [cite: 187]
        modelKeranjang.setRowCount(0); // Hapus semua baris
        updateTotalAndPoints();
    }

    /**
     * Logika untuk tombol "Cetak".
     */
    private void aksiPrint() {
        // 1. Pastikan struk tidak kosong
        if (txtStruk.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan lakukan Checkout terlebih dahulu.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // 2. Tampilkan dialog print (sesuai Halaman 21 )
        try {
            // Method print() dari JTextArea akan otomatis memunculkan dialog print
            boolean selesai = txtStruk.print();
            if (selesai) {
                JOptionPane.showMessageDialog(this, "Struk telah dikirim ke printer.", "Printing", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Proses print dibatalkan.", "Printing", JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Error saat mencetak: " + ex.getMessage(), "Print Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper method untuk menghitung ulang total dan poin.
     */
    private void updateTotalAndPoints() {
        totalBelanja = 0;
        
        // Loop isi keranjang dan hitung total
        for (int i = 0; i < modelKeranjang.getRowCount(); i++) {
            // Ambil subtotal dari kolom 4, tapi datanya (String "Rp8.000,00")
            // Lebih aman menghitung ulang dari qty (kolom 2) dan harga (dari data, bukan tabel)
            // Tapi untuk simplifikasi, kita ambil saja dari data produk
            int qty = (int) modelKeranjang.getValueAt(i, 2);
            
            // Cari harga berdasarkan ID (ini cara yg kurang efisien, tapi simpel utk contoh ini)
            String id = modelKeranjang.getValueAt(i, 0).toString();
            int harga = 0;
            for (int j = 0; j < tabelProduk.getRowCount(); j++) {
                if (tabelProduk.getValueAt(j, 0).equals(id)) {
                    harga = (int) tabelProduk.getValueAt(j, 2);
                    break;
                }
            }
            totalBelanja += (harga * qty);
        }
        
        // Poin: 1 per Rp 1000 [cite: 194]
        totalPoints = totalBelanja / 1000;
        
        // Update label
        lblTotal.setText("Total: " + formatRupiah.format(totalBelanja)); // [cite: 143]
        lblPoints.setText("Points: " + totalPoints); // [cite: 144]
    }
    
    /**
     * Helper method untuk mereset input setelah add to cart.
     */
    private void resetInput() {
        tabelProduk.clearSelection(); // Hapus seleksi di tabel produk
        selectedProductData = null; // Hapus data produk terpilih
        lblDipilih.setText("Pilih produk dari tabel di kiri"); // [cite: 117]
        txtQty.setText("1"); // Reset Qty
    }


    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PointOfSales().setVisible(true);
            }
        });
    }
}