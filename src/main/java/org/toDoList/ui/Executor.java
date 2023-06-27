package org.toDoList.ui;

import org.toDoList.domain.Task;
import org.toDoList.domain.source.FileDataSource;

import java.util.List;
import java.util.Scanner;

public class Executor {
    private boolean quitFlag = false;
    private final FileDataSource fileDataSource;
    private final ToDoUI toDoUI;
    private final Scanner scanner;

    public Executor(FileDataSource fileDataSource, ToDoUI toDoUI, Scanner scanner) {
        this.fileDataSource = fileDataSource;
        this.toDoUI = toDoUI;
        this.scanner = scanner;
    }

    private void outputTasks(List<Task> tasksToOutput) {
        String divider = "|" + "-".repeat(6) + "|" + "-".repeat(25) + "|" + "-".repeat(12) + "|" + "-".repeat(16) + "|" + "-".repeat(47) + "|";

        System.out.println("Current list of tasks: ");
        System.out.println(divider);
        System.out.format("| ID   | Task name               | Priority   | Deadline       | Notes " + " ".repeat(40) + "|\n");
        System.out.println(divider);
        if (tasksToOutput != null) {
            for (Task task : tasksToOutput) {
                String taskToOutput = "| %-4s ".formatted(toDoUI.getTasks().indexOf(task) + 1) + task.toString();
                if (task.isComplete()){
                    System.out.println("\u001B[32m" + taskToOutput + "\u001B[0m");
                } else {
                    System.out.println(taskToOutput);
                }
                System.out.println(divider);
            }
            System.out.println();
        }
    }
}
