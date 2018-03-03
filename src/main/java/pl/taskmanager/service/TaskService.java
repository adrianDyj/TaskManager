package pl.taskmanager.service;

import pl.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAll();

    Task findTask(long id);

    void save(Task task);

    void delete(long id);
}
