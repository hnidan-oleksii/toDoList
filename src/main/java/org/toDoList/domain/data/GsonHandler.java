package org.toDoList.domain.data;

import java.util.List;

public class GsonHandler implements JsonHandler{
    @Override
    public void writeJson(List<Task> tasks) {

    }

    @Override
    public List<Task> readJson(String tasks) {
        return null;
    }
}
