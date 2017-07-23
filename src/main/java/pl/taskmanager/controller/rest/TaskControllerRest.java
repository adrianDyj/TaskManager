package pl.taskmanager.controller.rest;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.taskmanager.dao.TaskRepository;
import pl.taskmanager.model.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskControllerRest {

	private TaskRepository taskRepository;
	
	@Autowired
	public TaskControllerRest(TaskRepository taskRepository){
		this.taskRepository = taskRepository;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Task> getTasks(@RequestParam(defaultValue="name") String orderBy){
		List<Task> tasks = taskRepository.findAll(); 
		if("name".equals(orderBy)){
			tasks.sort(Comparator.comparing(Task::getName));
		} else if("id".equals(orderBy)){
			tasks.sort(Comparator.comparing(Task::getId));
		}
		return tasks;
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task getTask(@PathVariable Long id){
		return taskRepository.findOne(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveTask(@RequestBody Task task){
		taskRepository.save(task);
	}
}

