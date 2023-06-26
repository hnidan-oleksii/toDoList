package org.toDoList.domain.source;

import org.toDoList.domain.Task;

import java.nio.file.Path;
import java.util.List;

public class JsonDataSource implements FileDataSource{
    private final JsonHandler jsonHandler;

    public JsonDataSource(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }

    @Override
    public List<Task> readFile(Path path) {

        return null;
    }

    @Override
    public void writeFile(Path path) {

    }
}
