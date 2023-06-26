package org.toDoList.domain;

import java.time.LocalDate;
import java.util.List;

public class ToDo {
    public void addTask(List<Task> tasks, Task task) {
        tasks.add(task);
    }

    public void editName(List<Task> tasks, Task task, String newName) {
        Task editedTask = new Task(task.isComplete(), newName, task.notes(), task.date(), task.priority());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void editNotes(List<Task> tasks, Task task, String newNotes) {
        Task editedTask = new Task(task.isComplete(), task.name(), newNotes, task.date(), task.priority());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void editDate(List<Task> tasks, Task task, LocalDate newDate) {
        Task editedTask = new Task(task.isComplete(), task.name(), task.notes(), newDate, task.priority());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void editPriority(List<Task> tasks, Task task, Task.Priority newPriority) {
        Task editedTask = new Task(task.isComplete(), task.name(), task.notes(), task.date(), newPriority);
        tasks.set(tasks.indexOf(task), editedTask);
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
