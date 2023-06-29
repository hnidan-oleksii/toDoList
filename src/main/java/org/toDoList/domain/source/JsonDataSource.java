package org.toDoList.domain.source;

import org.toDoList.domain.Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonDataSource implements FileDataSource{
    private final JsonHandler jsonHandler;
    private final String path = new File("").getAbsolutePath() +
            "./src/main/java/org/toDoList/domain/source/tasks.json";

    public JsonDataSource(JsonHandler jsonHandler) {
        this.jsonHandler = jsonHandler;
    }

    @Override
    public List<Task> readFile(){
        try {
            String json = new String(Files.readAllBytes(Path.of(path)));
            List<Task> tasks = jsonHandler.readJson(json);
            if (tasks != null) {
                return tasks;
            }
            throw new IllegalStateException("JSON file is empty");
        } catch (IllegalStateException | IOException e){
            return new ArrayList<>();
        }
    }

    @Override
    public void writeFile(List<Task> tasks) {
        jsonHandler.writeJson(tasks, path);
    }
}
