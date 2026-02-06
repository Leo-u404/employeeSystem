package ui;

import bean.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AddEmployeeUI extends JFrame {
    private JTextField txtID, txtName, txtGender, txtAge, txtPhoneNumber, txtPosition, txtSalary ,txtDepartment;
    private JFormattedTextField txtEmploymentDate;
    private JButton btnSave, btnCancel;
    private EmployeeManagerUI employeeManagerUI;

    public AddEmployeeUI(EmployeeManagerUI employeeManagerUI) {
        super("Add employee information");
        this.employeeManagerUI = employeeManagerUI;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        Font labelFont = new Font("Times New Roman", Font.PLAIN, 14);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel jLabel = new JLabel("ID:");
        jLabel.setFont(labelFont);
        add(jLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtID = new JTextField(10);
        add(txtID, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel jLabel2 = new JLabel("Name:");
        jLabel2.setFont(labelFont);
        add(jLabel2, gbc);

        gbc.gridx = 1;
        txtName = new JTextField(10);
        add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel jLabel3 = new JLabel("Gender:");
        jLabel3.setFont(labelFont);
        add(jLabel3, gbc);

        gbc.gridx = 1;
        txtGender = new JTextField(10);
        add(txtGender, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel jLabel4 = new JLabel("Age:");
        jLabel4.setFont(labelFont);
        add(jLabel4, gbc);

        gbc.gridx = 1;
        txtAge = new JTextField(10);
        add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel jLabel5 = new JLabel("PhoneNumber:");
        jLabel5.setFont(labelFont);
        add(jLabel5, gbc);

        gbc.gridx = 1;
        txtPhoneNumber = new JTextField(10);
        add(txtPhoneNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel jLabel6 = new JLabel("Position:");
        jLabel6.setFont(labelFont);
        add(jLabel6, gbc);

        gbc.gridx = 1;
        txtPosition = new JTextField(10);
        add(txtPosition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel jLabel7 = new JLabel("EmploymentDate:");
        jLabel7.setFont(labelFont);
        add(jLabel7, gbc);

        gbc.gridx = 1;
        txtEmploymentDate = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy"));
        add(txtEmploymentDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        JLabel jLabel8 = new JLabel("Salary:");
        jLabel8.setFont(labelFont);
        add(jLabel8, gbc);

        gbc.gridx = 1;
        txtSalary = new JTextField(10);
        add(txtSalary, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        JLabel jLabel9 = new JLabel("Department:");
        jLabel9.setFont(labelFont);
        add(jLabel9, gbc);

        gbc.gridx = 1;
        txtDepartment = new JTextField(10);
        add(txtDepartment, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        btnSave = new JButton("Add");
        btnCancel = new JButton("Cancel");
        btnSave.setPreferredSize(new Dimension(100,30));
        btnCancel.setPreferredSize(new Dimension(100,30));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        add(buttonPanel, gbc);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(txtID.getText()));
                employee.setName(txtName.getText());
                employee.setGender(txtGender.getText());
                employee.setAge(Integer.parseInt(txtAge.getText()));
                employee.setPhoneNumber(txtPhoneNumber.getText());
                employee.setPosition(txtPosition.getText());
                employee.setEmploymentDate(txtEmploymentDate.getText());
                employee.setSalary(Double.parseDouble(txtSalary.getText()));
                employee.setDepartment(txtDepartment.getText());

                employeeManagerUI.addEmployee(employee);

                JOptionPane.showMessageDialog(AddEmployeeUI.this, "Add successfully!");
                AddEmployeeUI.this.dispose();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployeeUI.this.dispose();
            }
        });

        pack();
        setSize(300,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
