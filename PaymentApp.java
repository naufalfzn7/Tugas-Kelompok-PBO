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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Pembayaran");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel labelInputTagihan = new JLabel("Masukkan Total Tagihan:");
        labelInputTagihan.setBounds(20, 20, 200, 25);
        frame.add(labelInputTagihan);

        JTextField fieldInputTagihan = new JTextField();
        fieldInputTagihan.setBounds(200, 20, 150, 25);
        frame.add(fieldInputTagihan);

        JLabel labelTagihan = new JLabel("Total Tagihan: Rp 0");
        labelTagihan.setBounds(20, 60, 200, 25);
        frame.add(labelTagihan);

        JLabel labelMetode = new JLabel("Pilih Metode Pembayaran:");
        labelMetode.setBounds(20, 100, 200, 25);
        frame.add(labelMetode);

        String[] metodePembayaran = {"Tunai", "Kartu Kredit/Debit", "E-Wallet"};
        JComboBox<String> comboMetode = new JComboBox<>(metodePembayaran);
        comboMetode.setBounds(200, 100, 150, 25);
        frame.add(comboMetode);

        JLabel labelPembayaran = new JLabel("Masukkan Pembayaran: ");
        labelPembayaran.setBounds(20, 140, 200, 25);
        frame.add(labelPembayaran);

        JTextField fieldPembayaran = new JTextField();
        fieldPembayaran.setBounds(200, 140, 150, 25);
        frame.add(fieldPembayaran);

        JButton submitButton = new JButton("Bayar");
        submitButton.setBounds(150, 190, 100, 30);
        frame.add(submitButton);

        JLabel labelHasil = new JLabel("");
        labelHasil.setBounds(20, 240, 350, 25);
        frame.add(labelHasil);

        JButton setTagihanButton = new JButton("Atur Tagihan");
        setTagihanButton.setBounds(200, 55, 150, 25);
        frame.add(setTagihanButton);

        setTagihanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double totalTagihan = Double.parseDouble(fieldInputTagihan.getText());
                    labelTagihan.setText("Total Tagihan: Rp " + totalTagihan);
                    labelHasil.setText(""); // Reset hasil sebelumnya
                } catch (NumberFormatException ex) {
                    labelHasil.setText("Masukkan angka total tagihan yang valid!");
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double totalTagihan = Double.parseDouble(fieldInputTagihan.getText());
                    double pembayaran = Double.parseDouble(fieldPembayaran.getText());

                    if (pembayaran < totalTagihan) {
                        labelHasil.setText("Jumlah pembayaran kurang dari total tagihan.");
                    } else {
                        double kembalian = pembayaran - totalTagihan;
                        String metode = (String) comboMetode.getSelectedItem();
                        if (kembalian > 0) {
                            labelHasil.setText("Metode: " + metode + ", Kembalian: Rp " + kembalian);
                        } else {
                            labelHasil.setText("Metode: " + metode + ", Tidak ada kembalian.");
                        }
                    }
                } catch (NumberFormatException ex) {
                    labelHasil.setText("Masukkan angka yang valid!");
                }
            }
        });

        frame.setVisible(true);
    }
}


