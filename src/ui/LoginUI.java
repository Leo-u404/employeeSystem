package ui;

import bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginUI extends JFrame implements ActionListener {
    private JTextField loginNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    private static ArrayList<User> allUsers = new ArrayList<>();

    static {
        allUsers.add(new User("Administrator", "123456", "admin"));
    }

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

        Font customFont = new Font("Times New Roman", Font.BOLD,18);
        Color primaryColor = new Color(66,135,245);
        Color secondaryColor = new Color(204,204,204);

        JLabel titleLabel = new JLabel("EMPLOYEE SYSTEM");
        titleLabel.setBounds(50,50,300,30);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,24));
        panel.add(titleLabel);

        JLabel usernameLabel = new JLabel("username: ");
        usernameLabel.setBounds(50,100,150,30);
        usernameLabel.setFont(customFont);
        panel.add(usernameLabel);

        loginNameField = new JTextField();
        loginNameField.setBounds(160,100,190,30);
        loginNameField.setFont(customFont);
        panel.add(loginNameField);

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
        loginButton.addActionListener(this);

        registerButton = new JButton("register");
        registerButton.setBounds(200,200,150,30);
        registerButton.setFont(customFont);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.BLACK);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        this.add(panel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn == loginButton) {
            login();
        }else {

        }
    }

    private void login() {
        String loginName = loginNameField.getText();
        String password = new String(passwordField.getPassword());

        User user = getUserByLoginName(loginName);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("login successfully!");
                new EmployeeManagerUI();
                this.dispose();
            }else {
                JOptionPane.showMessageDialog(this, "wrong password");
            }
        }else {
            JOptionPane.showMessageDialog(this, "illegal username");
        }
    }

    private User getUserByLoginName(String loginName) {
        for (int i = 0; i < allUsers.size(); i++) {
            User user = allUsers.get(i);
            if (user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }
}
