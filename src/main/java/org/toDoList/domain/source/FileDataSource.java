package org.toDoList.domain.source;


import org.toDoList.domain.Task;

import java.util.List;

public interface FileDataSource {
    List<Task> readFile();
    void writeFile(List<Task> tasks);
}
