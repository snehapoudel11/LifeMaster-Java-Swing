/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Task;
import view.UserDashboard;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */

public class UserTaskController {

    private UserDashboard view;
    private ArrayList<Task> taskList;
    private DefaultTableModel tableModel;

    public UserTaskController(UserDashboard view) {
        this.view = view;
        this.taskList = new ArrayList<>();

        tableModel = (DefaultTableModel) view.getTaskTable().getModel();
        addEventHandlers();
    }

    // ================= EVENT HANDLERS =================
    private void addEventHandlers() {
        view.getAddButton().addActionListener(e -> addTask());
        view.getUpdateButton().addActionListener(e -> updateTask());
        view.getDeleteButton().addActionListener(e -> deleteTask());
        view.getClearButton().addActionListener(e -> clearFields());
    }

    // ================= ADD TASK =================
    private void addTask() {
        try {
            int id = Integer.parseInt(view.getTaskIdField().getText());
            String title = view.getTitleField().getText();
            String category = view.getCategoryCombo().getSelectedItem().toString();
            int hours = Integer.parseInt(view.getHoursField().getText());
            int stress = Integer.parseInt(view.getStressField().getText());
            String date = view.getDateCombo().getSelectedItem().toString();

            // Validation
            if (!title.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(view, "Task title must contain only letters.");
                return;
            }

            Task task = new Task(id, title, category, hours, stress, date);
            taskList.add(task);

            tableModel.addRow(new Object[]{
                id, title, category, hours, stress, date
            });

            updateDashboardStats();
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Please enter valid numeric values.");
        }
    }

    // ================= UPDATE TASK =================
    private void updateTask() {
        int row = view.getTaskTable().getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select a task to update.");
            return;
        }

        try {
            String title = view.getTitleField().getText();
            String category = view.getCategoryCombo().getSelectedItem().toString();
            int hours = Integer.parseInt(view.getHoursField().getText());
            int stress = Integer.parseInt(view.getStressField().getText());
            String date = view.getDateCombo().getSelectedItem().toString();

            if (!title.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(view, "Task title must contain only letters.");
                return;
            }

            Task task = taskList.get(row);
            task.setTitle(title);
            task.setCategory(category);
            task.setHours(hours);
            task.setStressLevel(stress);
            task.setDate(date);

            tableModel.setValueAt(title, row, 1);
            tableModel.setValueAt(category, row, 2);
            tableModel.setValueAt(hours, row, 3);
            tableModel.setValueAt(stress, row, 4);
            tableModel.setValueAt(date, row, 5);

            updateDashboardStats();
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid input values.");
        }
    }

    // ================= DELETE TASK =================
    private void deleteTask() {
        int row = view.getTaskTable().getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select a task to delete.");
            return;
        }

        taskList.remove(row);
        tableModel.removeRow(row);

        updateDashboardStats();
        clearFields();
    }

    // ================= CLEAR =================
    private void clearFields() {
        view.getTaskIdField().setText("");
        view.getTitleField().setText("");
        view.getHoursField().setText("");
        view.getStressField().setText("");
    }

    // ================= DASHBOARD COUNTS =================
    private void updateDashboardStats() {

        int totalTasks = taskList.size();
        int highStress = 0;

        for (Task t : taskList) {
            if (t.getStressLevel() >= 7) {
                highStress++;
            }
        }

        view.getTasksTodayField().setText(String.valueOf(totalTasks));
        view.getHighStressField().setText(String.valueOf(highStress));
    }
}
