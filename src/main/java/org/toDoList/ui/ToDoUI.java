package org.toDoList.ui;

import org.toDoList.domain.Task;

import java.util.List;

public interface ToDoUI {
    void addTask();
    void editTask();
    void deleteTask();
    void markTaskCompleted();
    List<Task> searchByName();
    void sort();
    List<Task> getTasks();
}
