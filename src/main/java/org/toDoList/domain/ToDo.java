package org.toDoList.domain;

import org.toDoList.domain.data.Task;

import java.util.Collections;
import java.util.List;

public class ToDo {
    private int taskNumber = 0;

    private Task returnTaskById(List<Task> tasks, int id) {
        return tasks.stream().filter(task -> id == task.id()).findFirst().orElse(null);
    }

    public void addTask(List<Task> tasks, Task task) {
        taskNumber++;
        tasks.add(task);
    }

    public void editTask(List<Task> tasks) {

    }

    public void markTaskCompleted(List<Task> tasks, Task task) {

    }

    public void delete(List<Task> tasks) {

    }

    public List<Task> searchByName(List<Task> tasks) {
        return null;
    }


    public void sortByName(List<Task> tasks) {
        tasks.sort(new NameCompare());
    }

    public void sortByDate(List<Task> tasks){
        tasks.sort(new DateCompare());
    }

    public void sortById(List<Task> tasks){
        tasks.sort(new IdCompare());
    }

    public int getTaskNumber() {
        return taskNumber;
    }
}
