package org.toDoList.ui;

import org.toDoList.domain.Task;
import org.toDoList.domain.source.FileDataSource;

import java.time.LocalDate;
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

    public void run() {
        System.out.println("This is ToDo-List! You may find out list of the available commands by typing \"help\"");
        while (!quitFlag) {
            outputTasks(toDoUI.getTasks());
            commandHandler();
        }
    }

    private void commandHandler() {
        System.out.print("Enter the command: ");
        String command = scanner.nextLine().strip();

        switch (command) {
            case "help" -> System.out.println("""
                    To add new task, type "add"
                    To mark the task as complete, type "complete"
                    To edit the existing task, type "edit"
                    To delete existing task, type "delete"
                    To search for existing task, type "search"
                    To sort existing tasks, type "sort"
                    To quit the program, type "quit"
                    """);
            case "quit" -> {
                fileDataSource.writeFile(toDoUI.getTasks());
                quitFlag = true;
            }
            case "add" -> toDoUI.addTask();
            case "complete" -> toDoUI.markTaskCompleted();
            case "delete" -> toDoUI.deleteTask();
            case "edit" -> toDoUI.editTask();
            case "search" -> outputTasks(toDoUI.searchByName());
            case "sort" -> toDoUI.sort();
            default -> {
                System.out.println("Command is invalid. You can see list of all the commands by typing \"help\"");
                commandHandler();
            }
        }
    }

    private void outputTasks(List<Task> tasksToOutput) {
        String divider = "|" + "-".repeat(6) + "|" + "-".repeat(25)
                + "|" + "-".repeat(12) + "|" + "-".repeat(16)
                + "|" + "-".repeat(47) + "|";

        System.out.println("Current list of tasks: ");
        System.out.println(divider);
        System.out.format("| ID   | Task name               | Priority   | Deadline       | Notes " + " ".repeat(40) + "|\n");
        System.out.println(divider);

        if (tasksToOutput != null) {
            for (Task task : tasksToOutput) {
                String taskToOutput = "| %-4s ".formatted(toDoUI.getTasks().indexOf(task) + 1)
                        + task.toString();

                if (task.isComplete()) {
                    System.out.println("\u001B[32m" + taskToOutput + "\u001B[0m");
                } else if (task.date().isBefore(LocalDate.now())){
                    System.out.println("\u001B[31m" + taskToOutput + "\u001B[0m");
                } else {
                    System.out.println(taskToOutput);
                }
                System.out.println(divider);
            }
            System.out.println();
        }
    }
}
