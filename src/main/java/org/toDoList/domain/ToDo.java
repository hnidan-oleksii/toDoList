package org.toDoList.domain;

import org.toDoList.domain.data.Task;

import java.util.List;

public class ToDo {
    public void addTask(List<Task> tasks, Task task) {
        tasks.add(task);
    }

    public void editTask(List<Task> tasks) {

    }

    public void markTaskCompleted(List<Task> tasks, Task task) {
        Task completedTask = new Task(true, task.name(), task.notes(), task.date(), task.priority());
        tasks.set(tasks.indexOf(task), completedTask);
    }

    public void delete(List<Task> tasks, Task task) {
        tasks.remove(task);
    }

    public List<Task> searchByName(List<Task> tasks, String requestText) {
        return tasks.stream()
                .filter(task -> task.name().toLowerCase().contains(requestText.toLowerCase()))
                .toList();
    }


    public void sortByName(List<Task> tasks) {
        tasks.sort(new NameCompare());
    }

    public void sortByDate(List<Task> tasks) {
        tasks.sort(new DateCompare());
    }
}
