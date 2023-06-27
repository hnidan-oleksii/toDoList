package org.toDoList.domain.source;

import org.toDoList.domain.Task;

import java.util.List;

public interface JsonHandler {
    void writeJson(List<Task> tasks, String path);
    List<Task> readJson(String tasks);
}
