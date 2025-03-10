package latkuisss;

import javax.swing.*;

public class login extends JFrame {
    private JLabel lblUsername, lblPassword;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    private static final String USERNAME = "Virda Cantik";
    private static final String PASSWORD = "123230031";

    public login() {
        setTitle("Login");
        setSize(350, 200); // Lebih proporsional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Pusatkan window di layar
        setLayout(null); // Gunakan layout absolut seperti di praktikum

        // Label Username
        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 20, 80, 20);
        add(lblUsername);

        // Input Username
        usernameField = new JTextField();
        usernameField.setBounds(110, 20, 180, 25);
        add(usernameField);

        // Label Password
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 55, 80, 20);
        add(lblPassword);

        // Input Password
        passwordField = new JPasswordField();
        passwordField.setBounds(110, 55, 180, 25);
        add(passwordField);

        // Tombol Login
        loginButton = new JButton("Masuk");
        loginButton.setBounds(110, 90, 180, 25);
        add(loginButton);

        // Event Handling untuk Login
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                dispose(); // Tutup Login Window
                new hitungsiku();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
