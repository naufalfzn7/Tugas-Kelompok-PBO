/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas_akhir;

/**
 *
 * @author acer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorBangunRuang extends JFrame {

    // Konstruktor untuk GUI
    public KalkulatorBangunRuang() {
        setTitle("Kalkulator Bangun Ruang");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // Layout untuk 4 panel bangun ruang

        // Tambahkan setiap panel bangun ruang ke frame
        add(panelBalok());
        add(panelKubus());
        add(panelTabung());
        add(panelBola());

        setVisible(true); // Tampilkan GUI
    }

    // Panel Balok
    private JPanel panelBalok() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Balok"));

        // Input fields
        JTextField panjangField = new JTextField();
        JTextField lebarField = new JTextField();
        JTextField tinggiField = new JTextField();
        JLabel hasilLabel = new JLabel("Hasil: ");
        JButton hitungButton = new JButton("Hitung");

        // Tambahkan komponen ke panel
        panel.add(new JLabel("Panjang:"));
        panel.add(panjangField);
        panel.add(new JLabel("Lebar:"));
        panel.add(lebarField);
        panel.add(new JLabel("Tinggi:"));
        panel.add(tinggiField);
        panel.add(hitungButton);
        panel.add(hasilLabel);

        // Aksi tombol hitung
        hitungButton.addActionListener(e -> {
            try {
                double p = Double.parseDouble(panjangField.getText());
                double l = Double.parseDouble(lebarField.getText());
                double t = Double.parseDouble(tinggiField.getText());
                double volume = p * l * t;
                double luas = 2 * (p * l + p * t + l * t);
                hasilLabel.setText(String.format("Volume: %.2f, Luas: %.2f", volume, luas));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!");
            }
        });

        return panel;
    }

    // Panel Kubus
    private JPanel panelKubus() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Kubus"));

        JTextField sisiField = new JTextField();
        JLabel hasilLabel = new JLabel("Hasil: ");
        JButton hitungButton = new JButton("Hitung");

        panel.add(new JLabel("Sisi:"));
        panel.add(sisiField);
        panel.add(hitungButton);
        panel.add(hasilLabel);

        hitungButton.addActionListener(e -> {
            try {
                double s = Double.parseDouble(sisiField.getText());
                double volume = Math.pow(s, 3);
                double luas = 6 * Math.pow(s, 2);
                hasilLabel.setText(String.format("Volume: %.2f, Luas: %.2f", volume, luas));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!");
            }
        });

        return panel;
    }

    // Panel Tabung
    private JPanel panelTabung() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Tabung"));

        JTextField jariField = new JTextField();
        JTextField tinggiField = new JTextField();
        JLabel hasilLabel = new JLabel("Hasil: ");
        JButton hitungButton = new JButton("Hitung");

        panel.add(new JLabel("Jari-jari:"));
        panel.add(jariField);
        panel.add(new JLabel("Tinggi:"));
        panel.add(tinggiField);
        panel.add(hitungButton);
        panel.add(hasilLabel);

        hitungButton.addActionListener(e -> {
            try {
                double r = Double.parseDouble(jariField.getText());
                double t = Double.parseDouble(tinggiField.getText());
                double volume = Math.PI * r * r * t;
                double luas = 2 * Math.PI * r * (r + t);
                hasilLabel.setText(String.format("Volume: %.2f, Luas: %.2f", volume, luas));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!");
            }
        });

        return panel;
    }

    // Panel Bola
    private JPanel panelBola() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Bola"));

        JTextField jariField = new JTextField();
        JLabel hasilLabel = new JLabel("Hasil: ");
        JButton hitungButton = new JButton("Hitung");

        panel.add(new JLabel("Jari-jari:"));
        panel.add(jariField);
        panel.add(hitungButton);
        panel.add(hasilLabel);

        hitungButton.addActionListener(e -> {
            try {
                double r = Double.parseDouble(jariField.getText());
                double volume = 4.0 / 3.0 * Math.PI * Math.pow(r, 3);
                double luas = 4 * Math.PI * Math.pow(r, 2);
                hasilLabel.setText(String.format("Volume: %.2f, Luas: %.2f", volume, luas));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!");
            }
        });

        return panel;
    }

    // Main method
    public static void main(String[] args) {
        new KalkulatorBangunRuang();
    }
}

