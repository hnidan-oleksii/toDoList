package org.toDoList.ui;

import org.toDoList.domain.Task;
import org.toDoList.domain.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ToDoConsole implements ToDoUI{
    private final Scanner scanner;
    private final ToDo toDo;

    public ToDoConsole(Scanner scanner, ToDo todo) {
        this.scanner = scanner;
        this.toDo = todo;
    }

    @Override
    public void addTask() {
        Task newTask = new Task(setName(), setPriority(), setDate(), setNotes());
        toDo.addTask(newTask);
    }

    private String setName() {
        System.out.print("Enter name of the task: ");
        return scanner.nextLine();
    }

    private LocalDate setDate() {
        System.out.print("Enter deadline of the task (dd.mm.yyyy): ");

        try {
            String taskDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
            return LocalDate.parse(taskDate, formatter);
        } catch (DateTimeParseException exception) {
            System.out.println("\u001B[33m" + "You entered invalid date. Please enter the correct one." + "\u001B[0m");
            return setDate();
        }
    }

    private LocalDate setDate(String taskDate){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
            return LocalDate.parse(taskDate, formatter);
        } catch (DateTimeParseException exception) {
            System.out.println("\u001B[33m" + "You entered invalid date. Please enter the correct one." + "\u001B[0m");
            return setDate();
        }
    }

    private String setNotes() {
        System.out.print("Enter notes of the task: ");
        return scanner.nextLine();
    }

    private Task.Priority setPriority() {
        System.out.print("Enter priority of the task: ");

        try {
            String taskPriority = scanner.nextLine();
            return Task.Priority.valueOf(taskPriority);
        } catch (IllegalArgumentException exception) {
            System.out.println("\u001B[33m" + """
                    You entered invalid priority.
                    Priority can be: low, medium or high.
                    Enter the correct one""" + "\u001B[0m");
            return setPriority();
        }
    }

    private Task.Priority setPriority(String taskPriority) {
        System.out.print("Enter priority of the task: ");

        try {
            return Task.Priority.valueOf(taskPriority);
        } catch (IllegalArgumentException exception) {
            System.out.println("\u001B[33m" + """
                    You entered invalid priority.
                    Priority can be: low, medium or high.
                    Enter the correct one""" + "\u001B[0m");
            return setPriority();
        }
    }

    @Override
    public void editTask() {
        try {
            System.out.print("Enter number of the task you'd like to edit: ");
            int taskToEditId = Integer.parseInt(scanner.nextLine());
            Task taskToEdit = toDo.getTask(taskToEditId - 1);

            System.out.print("Enter name of the field you'd like to edit( name / priority / date / notes ) or quit: ");
            String fieldToEdit = scanner.nextLine().strip();
            System.out.print("Commit the changes: ");
            String editedFieldContent = scanner.nextLine();
            switch (fieldToEdit) {
                case "name" -> toDo.replaceWithEditedName(taskToEdit, editedFieldContent);
                case "priority" -> toDo.replaceWithEditedPriority(taskToEdit, setPriority(editedFieldContent));
                case "date" -> toDo.replaceWithEditedDate(taskToEdit, setDate(editedFieldContent));
                case "notes" -> toDo.replaceWithEditedNoes(taskToEdit, editedFieldContent);
                default -> System.out.println("\u001B[33m" + "Invalid field name. Enter the valid one" + "\u001B[0m");
            }


        } catch (IllegalArgumentException | IndexOutOfBoundsException exception) {
            System.out.println("\u001B[33m" + "Invalid either ID or data inputted. Enter the valid one" + "\u001B[0m");
            editTask();
        }

    }

    @Override
    public void deleteTask() {
        try {
            System.out.println("Enter number of the task you'd like to delete: ");
            int taskToDeleteId = Integer.parseInt(scanner.nextLine());
            toDo.delete(toDo.getTask(taskToDeleteId - 1));

        } catch (IllegalArgumentException | IndexOutOfBoundsException exception) {
            System.out.println("\u001B[33m" + "Invalid ID. Enter the valid one" + "\u001B[0m");
            deleteTask();
        }
    }

    @Override
    public void markTaskCompleted() {
        try {
            System.out.println("Enter number of the task you'd like to mark as complete: ");
            int taskToCompleteId = Integer.parseInt(scanner.nextLine());
            toDo.markTaskCompleted(toDo.getTask(taskToCompleteId - 1));

        } catch (IllegalArgumentException | IndexOutOfBoundsException exception) {
            System.out.println("\u001B[33m" + "Invalid ID. Enter the valid one" + "\u001B[0m");
            markTaskCompleted();
        }
    }

    @Override
    public List<Task> searchByName() {
        System.out.println("Enter your request: ");
        String searchRequest = scanner.nextLine();
        return toDo.searchByName(searchRequest);
    }

    @Override
    public void sort() {
        System.out.println("Enter criteria: ( name / date )");
        String criteria = scanner.nextLine().toLowerCase();
        switch (criteria){
            case "name" -> toDo.sortByName();
            case "date" -> toDo.sortByDate();
            default -> {
                System.out.println("\u001B[33m" + "Invalid criteria. Enter the valid one" + "\u001B[0m");
                sort();
            }
        }
    }

    @Override
    public List<Task> getTasks() {
        return toDo.getTasks();
    }
}
