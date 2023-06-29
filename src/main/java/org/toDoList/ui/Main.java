package org.toDoList.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.toDoList.domain.Task;
import org.toDoList.domain.ToDo;
import org.toDoList.domain.source.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        JsonHandler gsonHandler = new GsonHandler(gson);
        FileDataSource jsonDataSource = new JsonDataSource(gsonHandler);
        List<Task> tasks = jsonDataSource.readFile();
        ToDo todo = new ToDo(tasks);
        ToDoUI toDoUI = new ToDoConsole(scanner, todo);
        Executor executor = new Executor(jsonDataSource, toDoUI, scanner);

        executor.run();
    }
}