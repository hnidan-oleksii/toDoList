package org.toDoList.domain;

import org.toDoList.domain.data.Task;

import java.util.List;

public class ToDo {
    private int taskNumber = 0;

    public void addTask(List<Task> tasks, Task task) {
        taskNumber++;
        tasks.add(task);
    }

    public void editTask(List<Task> tasks) {

    }

    public void markTaskCompleted(List<Task> tasks, Task task) {

    }

    public void delete(List<Task> tasks){

    }

    public List<Task> searchByName(List<Task> tasks){
        return null;
    }

    public List<Task> sort(List<Task> tasks){
        return null;
    }

    public int getTaskNumber() {
        return taskNumber;
    }
}
