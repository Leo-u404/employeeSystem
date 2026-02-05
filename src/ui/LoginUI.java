package ui;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginUI(){
        super("LOGIN");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(240,240,240));

        Font customFont = new Font("楷体", Font.BOLD,18);
        Color primaryColor = new Color(66,135,245);
        Color secondaryColor = new Color(204,204,204);

        JLabel titleLabel = new JLabel("EMPLOYEE SYSTEM");
        titleLabel.setBounds(50,50,300,30);
        titleLabel.setFont(new Font("楷体",Font.BOLD,24));
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("username: ");
        usernameLabel.setBounds(50,100,150,30);
        usernameLabel.setFont(customFont);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(160,100,190,30);
        usernameField.setFont(customFont);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("password: ");
        passwordLabel.setBounds(50,150,150,30);
        passwordLabel.setFont(customFont);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(160,150,190,30);
        passwordField.setFont(customFont);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50,200,150,30);
        loginButton.setFont(customFont);
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        registerButton = new JButton("register");
        registerButton.setBounds(200,200,150,30);
        registerButton.setFont(customFont);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.BLACK);
        panel.add(registerButton);

        this.add(panel);
        this.setVisible(true);
    }


}
