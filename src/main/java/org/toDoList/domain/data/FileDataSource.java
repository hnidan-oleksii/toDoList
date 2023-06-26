package org.toDoList.domain.data;

import java.nio.file.Path;
import java.util.List;

public interface FileDataSource {
    List<Task> readFile(Path path);
    void writeFile(Path path);
}
