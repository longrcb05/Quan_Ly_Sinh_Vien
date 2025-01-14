package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login extends JFrame {
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnLogin, btnRegister;
    private JLabel lblNewLabel;
    private JSeparator separator;
    private JLabel lblNewLabel_1;
    private JCheckBox showPasswordCheckBox;

    public Login() {
        setTitle("Đăng nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 287);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setBounds(67, 95, 100, 25);
        getContentPane().add(lblUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(177, 95, 144, 25);
        getContentPane().add(textFieldUsername);

        JLabel lblPassword = new JLabel("Mật khẩu:");
        lblPassword.setBounds(67, 131, 100, 25);
        getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(177, 131, 144, 25);
        getContentPane().add(passwordField);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(67, 199, 100, 25);
        getContentPane().add(btnLogin);
        
        lblNewLabel = new JLabel("ĐĂNG NHẬP TÀI KHOẢN");
        lblNewLabel.setForeground(SystemColor.textHighlight);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(105, 25, 192, 25);
        getContentPane().add(lblNewLabel);
        
        separator = new JSeparator();
        separator.setBounds(10, 61, 370, 2);
        getContentPane().add(separator);
        
        lblNewLabel_1 = new JLabel("Xin mời nhập thông tin");
        lblNewLabel_1.setBounds(132, 70, 158, 14);
        getContentPane().add(lblNewLabel_1);

        showPasswordCheckBox = new JCheckBox("Hiển thị mật khẩu");
        showPasswordCheckBox.setBounds(173, 163, 150, 25);
        getContentPane().add(showPasswordCheckBox);

        // hien thi va an mat khau khi dang nhap
        showPasswordCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	// Hiển thị mật khẩu
                    passwordField.setEchoChar((char) 0);  
                } else {
                	// Ẩn mật khẩu
                    passwordField.setEchoChar('*');
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(passwordField.getPassword());

                if (checkLoginFromFile(username, password)) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công! Xin chào " + username);
                    new QLSVView().setVisible(true);
                    dispose(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu! Vui lòng nhập lại");
                }
            }
        });

        // button to change register
        btnRegister = new JButton("Đăng ký");
        btnRegister.setBounds(221, 199, 100, 25);
        getContentPane().add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register().setVisible(true);
                dispose(); 
            }
        });
    }

    public boolean checkLoginFromFile(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] account = line.split(",");
                if (account[0].equals(username) && account[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}

