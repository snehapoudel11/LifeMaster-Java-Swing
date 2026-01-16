/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */

public class Task {

    private int taskId;
    private String title;
    private String category;
    private int hours;
    private int stressLevel;
    private String date;

    // Constructor
    public Task(int taskId, String title, String category, int hours, int stressLevel, String date) {
        this.taskId = taskId;
        this.title = title;
        this.category = category;
        this.hours = hours;
        this.stressLevel = stressLevel;
        this.date = date;
    }

    // Getters
    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getHours() {
        return hours;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
