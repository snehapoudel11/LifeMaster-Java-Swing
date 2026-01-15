/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Dell
 */
import javax.swing.*;

    

public class UserLogin extends JFrame {
    public UserLogin() {
        setTitle("User Login");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblUser = new JLabel("Username:");
        JLabel lblPass = new JLabel("Password:");
        JTextField txtUser = new JTextField();
        JPasswordField txtPass = new JPasswordField();
        JButton btnLogin = new JButton("Login");

        lblUser.setBounds(30, 30, 80, 25);
        txtUser.setBounds(120, 30, 150, 25);
        lblPass.setBounds(30, 70, 80, 25);
        txtPass.setBounds(120, 70, 150, 25);
        btnLogin.setBounds(120, 110, 100, 30);

        add(lblUser); add(txtUser);
        add(lblPass); add(txtPass);
        add(btnLogin);

        btnLogin.addActionListener(e -> {
            new UserWindow().setVisible(true);
            this.dispose();
        });
    }
}


