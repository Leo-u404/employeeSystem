package ui;

import bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class EmployeeManagerUI extends JFrame{
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameTextFieldSearch;
    private static ArrayList<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(1, "Leo", "Male", 25, "0423413777", "Java developer", "06-02-2025", 3000, "Java"));
    }

    public  EmployeeManagerUI() {
    }

    public EmployeeManagerUI(String username) {
        super("Welcome, " + username);
        frame = this;
        initialize();
        this.setVisible(true);
    }

    public void loadEmployees(){
        for (Employee employee : employees) {
            model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getPhoneNumber(), employee.getPosition(), employee.getEmploymentDate(), employee.getSalary(), employee.getDepartment()});
        }
    }

    private void initialize() {
        this.setBounds(100,100,800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        nameTextFieldSearch = new JTextField(20);
        JButton btnSearch = new JButton("Search");
        JButton btnAdd = new JButton("Add");
        topPanel.add(nameTextFieldSearch);
        topPanel.add(btnSearch);
        topPanel.add(btnAdd);

        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "NAME", "GENDER", "AGE", "PHONE NUMBER", "POSITION", "EMPLOYMENT DATE", "SALARY", "DEPARTMENT"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {return false;}
        };

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setRowHeight(30);

        loadEmployees();

        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editItem = new JMenuItem("edit");
        JMenuItem deleteItem = new JMenuItem("delete");
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int row = table.rowAtPoint(e.getPoint());
                    if (row >= 0) {
                        table.setRowSelectionInterval(row, row);
                        popupMenu.show(table, e.getX(), e.getY());
                    }
                }
            }
        });

        editItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0){
                    int id = (Integer) model.getValueAt(selectedRow, 0);
                    Employee employee = getEmployeeById(id);
                    String newName = JOptionPane.showInputDialog(frame, "edit name: ", employee.getName());

                    if (newName != null) {
                        employee.setName(newName);

                        model.setValueAt(newName, selectedRow, 1);
                    }
                }

            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0){
                    int id = (Integer) model.getValueAt(selectedRow, 0);
                    employees.remove(getEmployeeById(id));
                    model.removeRow(selectedRow);
                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = nameTextFieldSearch.getText();
                if (searchValue.isEmpty()) {
                    clearTable();
                    loadEmployees();
                }else {
                    loadEmployeesByName(searchValue);
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeUI(EmployeeManagerUI.this);
            }
        });

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void loadEmployeesByName(String searchValue) {
        clearTable();
        for (Employee employee : employees) {
            if (employee.getName().contains(searchValue)) {
                model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getPhoneNumber(), employee.getPosition(), employee.getEmploymentDate(), employee.getSalary(), employee.getDepartment()});
            }
        }
    }

    private void clearTable() {
        model.setRowCount(0);
    }

    private Employee getEmployeeById(int id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        model.addRow(new Object[]{employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getPhoneNumber(), employee.getPosition(), employee.getEmploymentDate(), employee.getSalary(), employee.getDepartment()});
    }
}
