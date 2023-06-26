package org.toDoList.domain;

import org.toDoList.domain.data.Task;

import java.util.Comparator;

class NameCompare implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        return task1.name().compareTo(task2.name());
    }
}
class DateCompare implements Comparator<Task>{
    @Override
    public int compare(Task task1, Task task2) {
        return task1.date().compareTo(task2.date());
    }
}
