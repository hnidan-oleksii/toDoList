package org.toDoList.domain;

import java.time.LocalDate;

public record Task(boolean isComplete, String name, Priority priority, LocalDate date, String notes){
    public Task(String name, Priority priority, LocalDate date, String notes) {
        this(false, name, priority, date, notes);
    }

    @Override
    public String toString() {
        String[] formats = {"| %-23s ", "| %-10s ", "| %-14s ", "| %-45s |"};
        return formats[0].formatted(this.name) +
                formats[1].formatted(this.priority) +
                formats[2].formatted(this.date) +
                formats[3].formatted(this.notes);

    }

    public enum Priority {
        high("high"), medium("medium"), low("low");

        private final String priority;

        Priority(String priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return this.priority;
        }
    }
}
