package org.toDoList.domain.data;

import java.time.LocalDate;

public record Task(boolean isComplete, Integer id, String name, String notes, LocalDate date, Priority priority) {

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
}
