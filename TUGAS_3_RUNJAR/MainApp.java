public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Wrapper Project Koperasi ===");
        System.out.println("Menjalankan koperasi.jar...\n");

        try {
            // jalankan file JAR di folder lib
            Process p = Runtime.getRuntime().exec("java -jar lib/koperasi.jar");

            // tampilkan output dari koperasi.jar ke console
            new Thread(() -> {
                try (java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(p.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            p.waitFor(); // tunggu sampai koperasi.jar selesai jalan

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
