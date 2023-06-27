package org.toDoList.domain;

import java.time.LocalDate;

public record Task(boolean isComplete, String name, String notes, LocalDate date, Priority priority){
    public Task(String name, String notes, LocalDate date, Priority priority) {
        this(false, name, notes, date, priority);
    }

    public enum Priority {
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
}
