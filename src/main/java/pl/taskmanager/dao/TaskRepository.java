package pl.taskmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.taskmanager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
