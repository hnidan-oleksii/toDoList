package org.toDoList.domain.data;

import java.time.LocalDate;

public class Task {
    private boolean isComplete;
    private int id;
    private String name;
    private String notes;
    private LocalDate date;
    private Priority priority;

    public Task(String name, String notes, LocalDate date, Priority priority) {
        this.name = name;
        this.notes = notes;
        this.date = date;
        this.priority = priority;
    }

    private enum Priority {
        HIGH("high"), MEDIUM("medium"), LOW("low");

        private final String priority;

        Priority(String priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return this.priority;
        }
    }

    public boolean isComplete() {
        return isComplete;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
