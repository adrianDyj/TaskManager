package pl.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.taskmanager.dao.TaskRepository;
import pl.taskmanager.model.Task;
import pl.taskmanager.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		for(Task task: taskRepository.findAll()){
			tasks.add(task);
		}
		return tasks;
	}
	
	public Task findTask(long id){
		return taskRepository.findOne(id);
	}
	
	public void save(Task task){
		taskRepository.save(task);
	}
	
	public void delete(long id){
		taskRepository.delete(id);
	}
}
