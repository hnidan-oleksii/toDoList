package org.toDoList.domain.source;

import org.toDoList.domain.Task;

import java.nio.file.Path;
import java.util.List;

public interface FileDataSource {
    List<Task> readFile(Path path);
    void writeFile(Path path);
}
