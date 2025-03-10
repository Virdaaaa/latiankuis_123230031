package latkuisss;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class hitungsiku extends JFrame {
    private JLabel lblAlas, lblTinggi, lblHasil;
    private JTextField alasField, tinggiField;
    private JButton hitungButton;

    public hitungsiku() {
        setTitle("Hitung Sisi Miring Segitiga");
        setSize(350, 250); // Ukuran form
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Pusatkan window
        setLayout(null); // Gunakan layout absolut

        // Label & Input Alas
        lblAlas = new JLabel("Masukkan Alas:");
        lblAlas.setBounds(20, 20, 120, 20);
        add(lblAlas);

        alasField = new JTextField();
        alasField.setBounds(150, 20, 150, 25);
        add(alasField);

        // Label & Input Tinggi
        lblTinggi = new JLabel("Masukkan Tinggi:");
        lblTinggi.setBounds(20, 55, 120, 20);
        add(lblTinggi);

        tinggiField = new JTextField();
        tinggiField.setBounds(150, 55, 150, 25);
        add(tinggiField);

        // Tombol Hitung
        hitungButton = new JButton("Hitung");
        hitungButton.setBounds(100, 90, 150, 30);
        add(hitungButton);

        // Label Hasil
        lblHasil = new JLabel("Sisi Miring: ");
        lblHasil.setBounds(20, 135, 300, 25);
        add(lblHasil);

        // Event Handling
        hitungButton.addActionListener(e -> hitungSisiMiring());

        setVisible(true);
    }

    private void hitungSisiMiring() {
        try {
            double alas = Double.parseDouble(alasField.getText());
            double tinggi = Double.parseDouble(tinggiField.getText());

            if (alas <= 0 || tinggi <= 0) {
                throw new IllegalArgumentException("Nilai harus lebih dari 0");
            }

            double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
            lblHasil.setText("Sisi Miring: " + String.format("%.2f", sisiMiring));

            saveToFile(alas, tinggi, sisiMiring);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan ke file!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(double alas, double tinggi, double sisiMiring) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("hasil_perhitungan.txt", true))) {
            writer.printf("Alas: %.2f, Tinggi: %.2f, Sisi Miring: %.2f%n", alas, tinggi, sisiMiring);
        }
    }
}
