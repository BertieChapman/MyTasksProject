package com.bertrandechapman.mytasksproject;

import java.util.ArrayList;
import java.util.List;

public abstract class TaskProvider {

    private static final int DEFAULT_TASK_COUNT = 25;

    protected List<Task> tasks;

    protected TaskUpdateListener listener;

    protected TaskProvider() {
        this(DEFAULT_TASK_COUNT);
    }

    protected TaskProvider(int defaultCount) {
        tasks = new ArrayList<>(defaultCount);
    }

    public void addTaskUpdateListener(TaskUpdateListener listener) {
        this.listener = listener;
    }

    public interface TaskUpdateListener {

        void onNewTask(Task task);

        void onRemovedTask(Task task);

        void onTasksRetrieved(List<Task> tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void removeTask(int i) {
        listener.onRemovedTask(tasks.get(i));
        tasks.remove(i);
    }

    public void addTask(Task task) {
        tasks.add(task);
        listener.onNewTask(task);
    }
}
