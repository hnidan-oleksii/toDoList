package org.toDoList.domain.source;

import org.toDoList.domain.Task;

import java.util.List;

public interface JsonHandler {
    void writeJson(List<Task> tasks);
    List<Task> readJson(String tasks);
}
