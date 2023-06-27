package org.toDoList.domain.source;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import org.toDoList.domain.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GsonHandler implements JsonHandler {
    private final Gson gson;

    public GsonHandler(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void writeJson(List<Task> tasks, String path) {
        try (FileWriter fileWriter = new FileWriter(path)){
            gson.toJson(tasks, fileWriter);
        } catch (IOException | JsonIOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Task> readJson(String tasks) throws IllegalStateException{
        return gson.fromJson(tasks, new TypeToken<List<Task>>() {}.getType());
    }
}
