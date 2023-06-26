package org.toDoList.domain.data;

import java.util.List;

public interface JsonHandler {
    void writeJson(List<Task> tasks);
    List<Task> readJson(String tasks);
}
