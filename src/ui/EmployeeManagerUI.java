package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Stack;

public class EmployeeManagerUI extends JFrame{
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameTextFieldSearch;

    public  EmployeeManagerUI() {
        frame = this;
        initialize();
        this.setVisible(true);
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

        for (int i = 0; i < 20; i++) {
            model.addRow(new Object[]{i + 1, "employee" + (i + 1), "male", 21, "0411523986", "position" + (i + 1), new Date().toLocaleString(), 80000, "department" + (i + 1),});
        }

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
                    JOptionPane.showMessageDialog(frame, "edit ID: " + id);
                }
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0){
                    int id = (Integer) model.getValueAt(selectedRow, 0);
                    JOptionPane.showMessageDialog(frame, "delete ID: " + id);
                }
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchValue = nameTextFieldSearch.getText();
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
