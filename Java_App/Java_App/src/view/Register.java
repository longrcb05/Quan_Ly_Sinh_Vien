package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Register extends JFrame {
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton btnRegister;

    public Register() {
        setTitle("Đăng ký tài khoản");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(453, 320);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // username
        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setBounds(69, 97, 100, 25);
        getContentPane().add(lblUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(179, 97, 150, 25);
        getContentPane().add(textFieldUsername);

        // pass
        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setBounds(69, 133, 81, 25);
        getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(179, 133, 150, 25);
        getContentPane().add(passwordField);

        // confirm pass
        JLabel lblConfirmPassword = new JLabel("Nhập lại mật khẩu:");
        lblConfirmPassword.setBounds(69, 169, 109, 25);
        getContentPane().add(lblConfirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(179, 169, 150, 25);
        getContentPane().add(confirmPasswordField);

        // show/hide password
        JCheckBox showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
        showPasswordCheckBox.setBounds(179, 195, 150, 25);
        getContentPane().add(showPasswordCheckBox);

        // add item listener for both password fields
        showPasswordCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // hien thi ca 2
                    passwordField.setEchoChar((char) 0);
                    confirmPasswordField.setEchoChar((char) 0);
                } else {
                    // an ca 2
                    passwordField.setEchoChar('•');
                    confirmPasswordField.setEchoChar('•');
                }
            }
        });

        // button register
        btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(170, 230, 100, 25);
        getContentPane().add(btnRegister);

        JLabel lblNewLabel = new JLabel("ĐĂNG KÍ TÀI KHOẢN");
        lblNewLabel.setForeground(SystemColor.textHighlight);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(143, 22, 164, 40);
        getContentPane().add(lblNewLabel);

        JSeparator separator = new JSeparator();
        separator.setBounds(-12, 62, 521, 11);
        getContentPane().add(separator);

        JLabel lblNewLabel_1 = new JLabel("Vui lòng nhập đầy đủ thông tin");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(143, 72, 150, 14);
        getContentPane().add(lblNewLabel_1);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không khớp!");
                } else {
                    // save user and pass
                    saveAccountToFile(username, password);
                    JOptionPane.showMessageDialog(null, "Thêm mới tài khoản thành công!");
                    new Login().setVisible(true);
                    dispose();
                }
            }
        });
    }

    // luu tai khoan vao file
    public void saveAccountToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt", true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Register().setVisible(true);
            }
        });
    }
}


