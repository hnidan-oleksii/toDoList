package org.toDoList.domain;

import java.time.LocalDate;
import java.util.List;

public class ToDo {
    private final List<Task> tasks;

    public ToDo(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task getTask(int id) throws IndexOutOfBoundsException {
        return tasks.get(id);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void replaceWithEditedName(Task task, String newName) {
        Task editedTask = new Task(task.isComplete(), newName, task.priority(), task.date(), task.notes());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void replaceWithEditedNoes(Task task, String newNotes) {
        Task editedTask = new Task(task.isComplete(), task.name(), task.priority(), task.date(), newNotes);
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void replaceWithEditedDate(Task task, LocalDate newDate) {
        Task editedTask = new Task(task.isComplete(), task.name(), task.priority(), newDate, task.notes());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void replaceWithEditedPriority(Task task, Task.Priority newPriority) {
        Task editedTask = new Task(task.isComplete(), task.name(), newPriority, task.date(), task.notes());
        tasks.set(tasks.indexOf(task), editedTask);
    }

    public void markTaskCompleted(Task task) {
        Task completedTask = new Task(true, task.name(), task.priority(), task.date(), task.notes());
        tasks.set(tasks.indexOf(task), completedTask);
    }

    public void delete(Task task) {
        tasks.remove(task);
    }

    public List<Task> searchByName(String requestText) {
        return tasks.stream()
                .filter(task -> task.name().toLowerCase().contains(requestText.toLowerCase()))
                .toList();
    }


    public void sortByName() {
        tasks.sort(new NameCompare());
    }

    public void sortByDate() {
        tasks.sort(new DateCompare());
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
